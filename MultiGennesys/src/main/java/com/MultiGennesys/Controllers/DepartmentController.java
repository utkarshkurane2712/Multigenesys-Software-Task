package com.MultiGennesys.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MultiGennesys.DTOs.DepartmentDTO;
import com.MultiGennesys.DTOs.EmployeeDTO;
import com.MultiGennesys.Services.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
    @Autowired DepartmentService deptService;

    @PostMapping
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO dto) {
        return deptService.createDepartment(dto);
    }

    @GetMapping("/{deptId}")
    public List<EmployeeDTO> getEmployeesByDepartment(@PathVariable Long deptId) {
        return deptService.getEmployeesByDepartment(deptId);
    }
}
