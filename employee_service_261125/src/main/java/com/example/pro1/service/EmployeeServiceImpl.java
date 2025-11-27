package com.example.pro1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pro1.entity.Employee;
import com.example.pro1.exception.EmployeeNotFoundException;
import com.example.pro1.repository.EmployeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeRepository employeeRepo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee); // createdTime handled by @PrePersist
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        Optional<Employee> emp = employeeRepo.findById(id);
        if (emp.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found with id : " + id);
        }
        return emp;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee newData) {
        return employeeRepo.findById(id).map(emp -> {
            emp.setName(newData.getName());
            emp.setEmail(newData.getEmail());
            emp.setIpAddress(newData.getIpAddress());
            return employeeRepo.save(emp);
        }).orElseThrow(() ->
                new EmployeeNotFoundException("Cannot update. Employee not found with id : " + id)
        );
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepo.existsById(id)) {
            throw new EmployeeNotFoundException("Cannot delete. Employee not found with id : " + id);
        }
        employeeRepo.deleteById(id);
    }
}
