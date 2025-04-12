package com.MultiGennesys.Services;

import java.util.List;

import com.MultiGennesys.DTOs.DepartmentDTO;
import com.MultiGennesys.DTOs.EmployeeDTO;

public interface DepartmentService {
	
    DepartmentDTO createDepartment(DepartmentDTO dto);
    List<EmployeeDTO> getEmployeesByDepartment(Long deptId);

}
