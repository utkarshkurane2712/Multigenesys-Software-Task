package com.MultiGennesys.ServiceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MultiGennesys.DTOs.DepartmentDTO;
import com.MultiGennesys.DTOs.EmployeeDTO;
import com.MultiGennesys.DTOs.SalaryDTO;
import com.MultiGennesys.Entites.Department;
import com.MultiGennesys.Entites.Employee;
import com.MultiGennesys.Repos.DepartmentRepo;
import com.MultiGennesys.Repos.EmployeeRepo;
import com.MultiGennesys.Services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	   @Autowired DepartmentRepo deptRepo;
	    @Autowired EmployeeRepo empRepo;

	    public DepartmentDTO createDepartment(DepartmentDTO dto) {
	        Department dept = new Department();
	        dept.setName(dto.getName());
	        dept.setLocation(dto.getLocation());
	        dept = deptRepo.save(dept);
	        return mapToDTO(dept);
	    }

	    public List<EmployeeDTO> getEmployeesByDepartment(Long deptId) {
	        return empRepo.findByDepartmentId(deptId)
	                      .stream()
	                      .map(this::mapEmployeeToDTO)
	                      .collect(Collectors.toList());
	    }

	    private DepartmentDTO mapToDTO(Department dept) {
	        DepartmentDTO dto = new DepartmentDTO();
	        dto.setId(dept.getId());
	        dto.setName(dept.getName());
	        dto.setLocation(dept.getLocation());
	        
	        if (dept.getEmployees() != null) {
	            dto.setEmployees(dept.getEmployees().stream().map(this::mapEmployeeToDTO).collect(Collectors.toList()));
	        }
	        return dto;
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
