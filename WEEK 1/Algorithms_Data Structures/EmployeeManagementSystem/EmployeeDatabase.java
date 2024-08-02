// EmployeeDatabase.java
import java.io.*;
import java.util.*;

public class EmployeeDatabase {
    private static final String DATABASE_FILE = "employee_database.txt";

    public void updateDatabase(List<Employee> employees) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATABASE_FILE))) {
            for (Employee employee : employees) {
                writer.println(employee.getEmployeeId() + "," + employee.getSalary());
            }
            System.out.println("Database updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating database: " + e.getMessage());
        }
    }

    public void displayDatabase() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;
            System.out.println("Employee Database:");
            System.out.println("ID\tSalary");
            while ((line = reader.readLine()) != null) {
                System.out.println(line.replace(",", "\t"));
            }
        } catch (IOException e) {
            System.out.println("Error reading database: " + e.getMessage());
        }
    }
}