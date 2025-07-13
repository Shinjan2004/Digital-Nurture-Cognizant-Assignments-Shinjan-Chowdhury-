package com.example.jpademo.repository;

import com.example.jpademo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  // inherits save(), findAll(), findById(), delete(), etc.
}
