package com.MultiGennesys.Repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MultiGennesys.Entites.Designation;
import com.MultiGennesys.Entites.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
    List<Employee> findByDesignation(Designation designation);
    List<Employee> findBySalaryAmountBetween(Double min, Double max);
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findByDepartmentId(Long departmentId);

}
