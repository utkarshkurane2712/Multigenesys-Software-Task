package com.MultiGennesys.DTOs;

import java.util.List;

import com.MultiGennesys.Entites.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
	
    private Long id;
    private String name;
    private String location;
    private List<EmployeeDTO> employees;
}
