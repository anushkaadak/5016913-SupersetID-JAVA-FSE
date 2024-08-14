package com.example.employeemanagementsystem.repository;


import com.example.employeemanagementsystem.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    

    List<Employee> findByName(String name);

    Employee findByEmail(String email);
}
