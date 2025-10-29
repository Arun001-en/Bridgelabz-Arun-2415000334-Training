package constructors;
//Course.java
public class Course {
 // Instance variables
 private String courseName;
 private int duration;   // in months
 private double fee;

 // Class variable (shared among all courses)
 private static String instituteName = "Default Institute";

 // Constructor
 public Course(String courseName, int duration, double fee) {
     this.courseName = courseName;
     this.duration = duration;
     this.fee = fee;
 }

 // Instance method to display course details
 public void displayCourseDetails() {
     System.out.println("Institute: " + instituteName);
     System.out.println("Course Name: " + courseName);
     System.out.println("Duration: " + duration + " months");
     System.out.println("Fee: ₹" + fee);
     System.out.println("----------------------------");
 }

 // Class method to update institute name
 public static void updateInstituteName(String newName) {
     instituteName = newName;
 }

 // Main method for testing
 public static void main(String[] args) {
     // Create courses
     Course c1 = new Course("Java Programming", 6, 15000);
     Course c2 = new Course("Web Development", 4, 12000);

     // Display details with default institute name
     c1.displayCourseDetails();
     c2.displayCourseDetails();

     // Update institute name (applies to all courses)
     Course.updateInstituteName("GLA University");

     // Display details again after update
     c1.displayCourseDetails();
     c2.displayCourseDetails();
 }
}
