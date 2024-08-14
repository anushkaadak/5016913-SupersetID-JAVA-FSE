package com.managementsystem.employee_management_system.repositories;

import com.managementsystem.employee_management_system.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
