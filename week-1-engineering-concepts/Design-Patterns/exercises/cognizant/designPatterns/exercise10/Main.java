package cognizant.designPatterns.exercise10;

public class Main {
    public static void main(String[] args) {

        Student student = new Student(101, "Adwait", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        System.out.println("Initial Student Details\n");
        controller.updateView();

        System.out.println();

        controller.setStudentName("Rahul");
        controller.setStudentGrade("A+");

        System.out.println("Updated Student Details\n");
        controller.updateView();

    }
}