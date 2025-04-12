package com.MultiGennesys.DTOs;

import java.time.LocalDate;

import com.MultiGennesys.Entites.Designation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private Designation designation;
    private LocalDate joiningDate;
    private SalaryDTO salary;
    
}
