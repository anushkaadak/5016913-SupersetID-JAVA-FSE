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

    public String toString() {
        return "Task ID: " + taskId + ", Task Name: " + taskName + ", Status: " + status;
    }
}

class TaskManagementSystem {
    private Task head;

    public TaskManagementSystem() {
        this.head = null;
    }

    public void addTask(int taskId, String taskName, String status) {
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
    }

    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        if (head.taskId == taskId) {
            head = head.next;
            return;
        }
        Task current = head;
        while (current.next != null && current.next.taskId != taskId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Task not found.");
            return;
        }
        current.next = current.next.next;
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(1, "Task 1", "Pending");
        tms.addTask(2, "Task 2", "In Progress");
        tms.addTask(3, "Task 3", "Completed");

        System.out.println("All Tasks:");
        tms.traverseTasks();

        System.out.println("Searching for task with ID 2:");
        Task task = tms.searchTask(2);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("Deleting task with ID 2:");
        tms.deleteTask(2);

        System.out.println("All Tasks after deletion:");
        tms.traverseTasks();
    }
}
