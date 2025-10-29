class Student {
    private static String universityName = "Delhi University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
        }
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(101, "Akshit", "A");
        Student student2 = new Student(102, "Preeti", "B");

        student1.displayStudentDetails();
        System.out.println();
        student2.displayStudentDetails();

        System.out.println();
        Student.displayTotalStudents();

        System.out.println("\nUpdating Preeti's grade...\n");
        student2.updateGrade("A+");
        student2.displayStudentDetails();
    }
}
