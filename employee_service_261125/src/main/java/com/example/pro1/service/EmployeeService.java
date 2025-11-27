package com.example.pro1.service;

import java.util.List;
import java.util.Optional;
import com.example.pro1.entity.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}
