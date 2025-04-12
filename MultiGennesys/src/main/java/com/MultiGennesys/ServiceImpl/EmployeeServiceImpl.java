package com.MultiGennesys.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MultiGennesys.DTOs.EmployeeDTO;
import com.MultiGennesys.DTOs.SalaryDTO;
import com.MultiGennesys.Entites.Department;
import com.MultiGennesys.Entites.Designation;
import com.MultiGennesys.Entites.Employee;
import com.MultiGennesys.Entites.Salary;
import com.MultiGennesys.Repos.DepartmentRepo;
import com.MultiGennesys.Repos.EmployeeRepo;
import com.MultiGennesys.Services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired EmployeeRepo empRepo;
    @Autowired DepartmentRepo deptRepo;

    public EmployeeDTO createEmployee(Long deptId, EmployeeDTO dto) {
        Department dept = deptRepo.findById(deptId).orElseThrow();
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setDesignation(dto.getDesignation());
        emp.setJoiningDate(dto.getJoiningDate());
        emp.setDepartment(dept);

        Salary salary = new Salary();
        salary.setAmount(dto.getSalary().getAmount());

        // Set both directions
        emp.setSalary(salary);
        salary.setEmployee(emp);

        emp = empRepo.save(emp); // Salary will be saved due to cascade
        return mapEmployeeToDTO(emp);
    }


    public List<EmployeeDTO> getByDesignation(Designation designation) {
        return empRepo.findByDesignation(designation).stream()
                      .map(this::mapEmployeeToDTO)
                      .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getBySalaryRange(Double min, Double max) {
        return empRepo.findBySalaryAmountBetween(min, max).stream()
                      .map(this::mapEmployeeToDTO)
                      .collect(Collectors.toList());
    }

    public Page<EmployeeDTO> getAllPaginated(int page, int size, Designation designation, Double minSalary, Double maxSalary) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employees = empRepo.findAll(pageable);
        return employees.map(this::mapEmployeeToDTO);
    }

    private EmployeeDTO mapEmployeeToDTO(Employee emp) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setDesignation(emp.getDesignation());
        dto.setJoiningDate(emp.getJoiningDate());
        if (emp.getSalary() != null) {
            SalaryDTO salaryDTO = new SalaryDTO();
            salaryDTO.setId(emp.getSalary().getId());
            salaryDTO.setAmount(emp.getSalary().getAmount());
            dto.setSalary(salaryDTO);
        }
        return dto;
    }
}
