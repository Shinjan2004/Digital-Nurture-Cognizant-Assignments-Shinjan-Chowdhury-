package com.example.jpademo.service;

import com.example.jpademo.model.Employee;
import com.example.jpademo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Transactional
  public Employee addEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }
}
