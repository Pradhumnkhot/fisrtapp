package com.example.pro1.controller;

import java.util.List;
import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.pro1.entity.Employee;
import com.example.pro1.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class ApiController {

    @Autowired
    private EmployeeService employeeService;

    // Create Employee (captures client IP automatically)
    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee, HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        employee.setIpAddress(clientIp);
        return employeeService.saveEmployee(employee);
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Update employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee, HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        employee.setIpAddress(clientIp);
        return employeeService.updateEmployee(id, employee);
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Deleted Successfully";
    }
}
