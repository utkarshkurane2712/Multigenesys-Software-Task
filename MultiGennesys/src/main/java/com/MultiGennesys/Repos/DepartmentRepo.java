package com.MultiGennesys.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MultiGennesys.Entites.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
