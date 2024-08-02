// EmployeeManagementSystem.java
import java.util.Arrays;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
    private EmployeeDatabase database;

    public EmployeeManagementSystem() {
        employees = new Employee[INITIAL_CAPACITY];
        size = 0;
        database = new EmployeeDatabase();
    }

    public void addEmployee(Employee employee) {
        if (size == employees.length) {
            employees = Arrays.copyOf(employees, employees.length * 2);
        }
        employees[size++] = employee;
        System.out.println("Employee added: " + employee);
        updateDatabase();
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        System.out.println("All Employees:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                System.out.println("Employee deleted: " + employees[i]);
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                updateDatabase();
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }

    private void updateDatabase() {
        database.updateDatabase(Arrays.asList(Arrays.copyOf(employees, size)));
    }

    public void displayDatabase() {
        database.displayDatabase();
    }
}