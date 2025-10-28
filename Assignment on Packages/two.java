
class Course {
    private String courseName;
    private int courseCode;
    private String instructor;

    public Course(String courseName, int courseCode, String instructor) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = instructor;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Instructor: " + instructor);
    }
}


public class two{
    public static void main(String[] args) {
        Course c1 = new Course("Data Structures", 201, "Prof. Sharma");
        c1.displayCourseDetails();
    }
}
