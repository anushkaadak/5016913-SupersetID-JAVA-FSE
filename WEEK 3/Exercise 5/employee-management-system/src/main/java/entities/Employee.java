package com.managementsystem.employee_management_system.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@NamedQueries({
        @NamedQuery(
                name = "Employee.findByLastName",
                query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"
        ),
        @NamedQuery(
                name = "Employee.findByDepartmentId",
                query = "SELECT e FROM Employee e WHERE e.department.id = :departmentId"
        )
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
