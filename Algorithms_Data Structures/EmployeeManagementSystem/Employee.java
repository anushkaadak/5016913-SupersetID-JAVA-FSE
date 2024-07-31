import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private int capacity;

    public EmployeeManagementSystem(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size == capacity) {
            System.out.println("Array is full. Cannot add more employees.");
            return;
        }
        employees[size] = employee;
        size++;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null;
        size--;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        ems.addEmployee(new Employee(1, "Alice", "Manager", 75000));
        ems.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        ems.addEmployee(new Employee(3, "Charlie", "Analyst", 50000));

        System.out.println("All Employees:");
        ems.traverseEmployees();

        System.out.println("Searching for employee with ID 2:");
        Employee emp = ems.searchEmployee(2);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("Deleting employee with ID 2:");
        ems.deleteEmployee(2);

        System.out.println("All Employees after deletion:");
        ems.traverseEmployees();
    }
}
