package com.example.pro1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "employees2")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50)
    private String name;

    @Column(name = "employee_email")
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @Column(name = "ip_address")
    private String ipAddress;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a, dd-MM-yyyy")
    @Column(name = "created_time")
    private LocalDateTime createdTime;

    // Automatically set creation time
    @PrePersist
    public void onCreate() {
        this.createdTime = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }
}
