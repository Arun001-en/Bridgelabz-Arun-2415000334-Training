package constructors;
//Person.java
public class Person {
 // Attributes
 private String name;
 private int age;

 // Default constructor
 public Person() {
     this.name = "Unknown";
     this.age = 0;
 }

 // Parameterized constructor
 public Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 // Copy constructor
 public Person(Person other) {
     this.name = other.name;
     this.age = other.age;
 }

 // Method to display details
 public void displayDetails() {
     System.out.println("Name: " + name + ", Age: " + age);
 }

 // Main method for testing
 public static void main(String[] args) {
     // Original person
     Person p1 = new Person("Chhavi", 20);
     p1.displayDetails();

     // Copy person using copy constructor
     Person p2 = new Person(p1);
     p2.displayDetails();
 }
}
