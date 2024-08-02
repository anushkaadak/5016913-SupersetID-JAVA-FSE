// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Display Database");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee(ems, scanner);
                    break;
                case 2:
                    searchEmployee(ems, scanner);
                    break;
                case 3:
                    ems.traverseEmployees();
                    break;
                case 4:
                    deleteEmployee(ems, scanner);
                    break;
                case 5:
                    ems.displayDatabase();
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee(EmployeeManagementSystem ems, Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee position: ");
        String position = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        Employee newEmployee = new Employee(id, name, position, salary);
        ems.addEmployee(newEmployee);
    }

    private static void searchEmployee(EmployeeManagementSystem ems, Scanner scanner) {
        System.out.print("Enter employee ID to search: ");
        int searchId = scanner.nextInt();
        Employee foundEmployee = ems.searchEmployee(searchId);
        if (foundEmployee != null) {
            System.out.println("Found employee: " + foundEmployee);
        } else {
            System.out.println("Employee with ID " + searchId + " not found.");
        }
    }

    private static void deleteEmployee(EmployeeManagementSystem ems, Scanner scanner) {
        System.out.print("Enter employee ID to delete: ");
        int deleteId = scanner.nextInt();
        ems.deleteEmployee(deleteId);
    }
}