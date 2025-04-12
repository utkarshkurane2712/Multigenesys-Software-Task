package com.MultiGennesys.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MultiGennesys.Entites.Salary;

@Repository
public interface SalaryRepo extends JpaRepository<Salary, Long> {

}
