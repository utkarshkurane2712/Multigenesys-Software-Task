package com.MultiGennesys.Services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.MultiGennesys.DTOs.EmployeeDTO;
import com.MultiGennesys.Entites.Designation;

public interface EmployeeService {
	
    EmployeeDTO createEmployee(Long deptId, EmployeeDTO dto);
    List<EmployeeDTO> getByDesignation(Designation designation);
    List<EmployeeDTO> getBySalaryRange(Double min, Double max);
    Page<EmployeeDTO> getAllPaginated(int page, int size, Designation designation, Double minSalary, Double maxSalary);
}
