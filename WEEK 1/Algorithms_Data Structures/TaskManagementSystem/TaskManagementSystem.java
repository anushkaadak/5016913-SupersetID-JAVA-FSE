import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

class TaskList {
    private Task head;
    private Scanner scanner;

    public TaskList() {
        this.head = null;
        this.scanner = new Scanner(System.in);
    }

    // Check if taskId already exists
    public boolean isTaskIdExists(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Add a new task to the end of the list
    public void addTask() {
        int taskId;
        do {
            System.out.print("Enter Task ID: ");
            taskId = scanner.nextInt();
            if (isTaskIdExists(taskId)) {
                System.out.println("Task ID already exists. Please enter a different ID.");
            }
        } while (isTaskIdExists(taskId));

        scanner.nextLine(); // Consume newline
        System.out.print("Enter Task Name: ");
        String taskName = scanner.nextLine();
        System.out.print("Enter Task Status: ");
        String status = scanner.nextLine();

        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added successfully.");
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.taskId + 
                               ", Name: " + current.taskName + 
                               ", Status: " + current.status);
            current = current.next;
        }
    }

    // Delete a task by taskId
    public void deleteTask() {
        if (head == null) {
            System.out.println("No tasks available to delete.");
            return;
        }

        System.out.print("Enter Task ID to delete: ");
        int taskId = scanner.nextInt();

        if (head.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Task current = head;
        Task prev = null;
        while (current != null && current.taskId != taskId) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task not found.");
            return;
        }

        prev.next = current.next;
        System.out.println("Task deleted successfully.");
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Task Management System ---");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    taskList.addTask();
                    break;
                case 2:
                    taskList.traverseTasks();
                    break;
                case 3:
                    taskList.deleteTask();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}