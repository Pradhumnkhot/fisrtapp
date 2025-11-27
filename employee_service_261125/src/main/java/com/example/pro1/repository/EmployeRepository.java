package com.example.pro1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pro1.entity.Employee;

public interface EmployeRepository extends JpaRepository<Employee, Long> {
}
