package com.MultiGennesys.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MultiGennesys.DTOs.EmployeeDTO;
import com.MultiGennesys.Entites.Designation;
import com.MultiGennesys.Services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired EmployeeService empService;

    @PostMapping("/department/{deptId}")
    public EmployeeDTO create(@PathVariable Long deptId, @RequestBody EmployeeDTO dto) {
        return empService.createEmployee(deptId, dto);
    }

    @GetMapping("/filter")
    public Page<EmployeeDTO> filter(@RequestParam int page,
                                    @RequestParam int size,
                                    @RequestParam(required = false) Designation designation,
                                    @RequestParam(required = false) Double minSalary,
                                    @RequestParam(required = false) Double maxSalary) {
        return empService.getAllPaginated(page, size, designation, minSalary, maxSalary);
    }

    @GetMapping("/designation/{designation}")
    public List<EmployeeDTO> getByDesignation(@PathVariable Designation designation) {
        return empService.getByDesignation(designation);
    }

    @GetMapping("/salary-range")
    public List<EmployeeDTO> getBySalaryRange(@RequestParam Double min,
                                              @RequestParam Double max) {
        return empService.getBySalaryRange(min, max);
    }
}
