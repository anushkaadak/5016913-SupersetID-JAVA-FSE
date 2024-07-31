package mvc.pattern;

public class MVCPatternExample {
    public static void main(String[] args) {
        Student model = retrieveStudentFromDatabase();

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Sabyasachi Ghosh");
        controller.setStudentGrade("A");

        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Supratim Ghosh");
        student.setId("5016702");
        student.setGrade("A");
        return student;
    }
}