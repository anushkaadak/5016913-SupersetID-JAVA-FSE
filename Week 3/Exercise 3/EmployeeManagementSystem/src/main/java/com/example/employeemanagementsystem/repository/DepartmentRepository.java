package com.example.employeemanagementsystem.repository;


import com.example.employeemanagementsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    

    List<Department> findByName(String name);
}
