import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    String grade;
    Student next;

    Student(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentLinkedList {

    static Student head = null;
    static Scanner sc = new Scanner(System.in);
    static void insertBeginning() {
        System.out.print("Enter Roll: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        String grade = sc.next();

        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;

        System.out.println("Student added at beginning.");
    }
    static void insertEnd() {
        System.out.print("Enter Roll: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        String grade = sc.next();

        Student newNode = new Student(roll, name, age, grade);

        if (head == null) {
            head = newNode;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        System.out.println("Student added at end.");
    }
    static void insertPosition() {
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();

        if (pos == 1) {
            insertBeginning();
            return;
        }

        System.out.print("Enter Roll: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        String grade = sc.next();

        Student newNode = new Student(roll, name, age, grade);

        Student temp = head;
        int count = 1;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Student inserted at position " + pos);
    }

    // Delete by Roll
    static void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = sc.nextInt();

        Student temp = head, prev = null;

        while (temp != null && temp.roll != roll) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Student not found!");
            return;
        }

        if (prev == null) {
            head = temp.next;
        } else {
            prev.next = temp.next;
        }

        System.out.println("Student deleted successfully.");
    }
    static void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();

        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Record Found:");
                System.out.println("Roll: " + temp.roll);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found!");
    }
    static void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Student temp = head;

        System.out.println("\nStudent Records:");
        while (temp != null) {
            System.out.println("Roll: " + temp.roll +
                               " | Name: " + temp.name +
                               " | Age: " + temp.age +
                               " | Grade: " + temp.grade);
            temp = temp.next;
        }
    }
    static void updateGrade() {
        System.out.print("Enter Roll Number to update: ");
        int roll = sc.nextInt();

        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.print("Enter New Grade: ");
                temp.grade = sc.next();
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found!");
    }
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Display All Records");
            System.out.println("7. Update Grade");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: insertBeginning(); break;
                case 2: insertEnd(); break;
                case 3: insertPosition(); break;
                case 4: deleteStudent(); break;
                case 5: searchStudent(); break;
                case 6: display(); break;
                case 7: updateGrade(); break;
                case 8: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
