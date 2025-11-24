// Student Result Management System (simple, console-based)
// Files included below. Save each file in same package/folder (e.g., src/) and compile.

// ---------- File: Student.java ----------
package srms;

public class Student {
    private int id;
    private String name;
    private String course;
    private int semester;

    public Student() {}

    public Student(int id, String name, String course, int semester) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.semester = semester;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', course='%s', semester=%d}", id, name, course, semester);
    }
}

// ---------- File: Result.java ----------
package srms;

public class Result {
    private int id; // result id
    private int studentId;
    private int marks1;
    private int marks2;
    private int marks3;

    public Result() {}

    public Result(int id, int studentId, int marks1, int marks2, int marks3) {
        this.id = id;
        this.studentId = studentId;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public int getMarks1() { return marks1; }
    public void setMarks1(int marks1) { this.marks1 = marks1; }
    public int getMarks2() { return marks2; }
    public void setMarks2(int marks2) { this.marks2 = marks2; }
    public int getMarks3() { return marks3; }
    public void setMarks3(int marks3) { this.marks3 = marks3; }

    public int total() { return marks1 + marks2 + marks3; }

    public char grade() {
        int t = total();
        int avg = t / 3;
        if (avg >= 90) return 'A';
        if (avg >= 75) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }

    @Override
    public String toString() {
        return String.format("Result{id=%d, studentId=%d, marks=[%d,%d,%d], total=%d, grade=%c}", id, studentId, marks1, marks2, marks3, total(), grade());
    }
}

// ---------- File: DatabaseManager.java ----------
package srms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/srms_db?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root"; // change as needed
    private static final String PASS = "root"; // change as needed

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

// ---------- File: StudentDAO.java ----------
package srms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Create
    public void addStudent(Student s) throws SQLException {
        String sql = "INSERT INTO students (id, name, course, semester) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getSemester());
            ps.executeUpdate();
        }
    }

    // Read all
    public List<Student> getAllStudents() throws SQLException {
        String sql = "SELECT id, name, course, semester FROM students";
        List<Student> list = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("course"), rs.getInt("semester"));
                list.add(s);
            }
        }
        return list;
    }

    // Read single
    public Student getStudentById(int id) throws SQLException {
        String sql = "SELECT id, name, course, semester FROM students WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("course"), rs.getInt("semester"));
                }
            }
        }
        return null;
    }

    // Update
    public boolean updateStudent(Student s) throws SQLException {
        String sql = "UPDATE students SET name = ?, course = ?, semester = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setInt(3, s.getSemester());
            ps.setInt(4, s.getId());
            int affected = ps.executeUpdate();
            return affected > 0;
        }
    }

    // Delete
    public boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected > 0;
        }
    }
}

// ---------- File: ResultDAO.java ----------
package srms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO {
    public void addResult(Result r) throws SQLException {
        String sql = "INSERT INTO results (id, student_id, marks1, marks2, marks3) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, r.getId());
            ps.setInt(2, r.getStudentId());
            ps.setInt(3, r.getMarks1());
            ps.setInt(4, r.getMarks2());
            ps.setInt(5, r.getMarks3());
            ps.executeUpdate();
        }
    }

    public List<Result> getResultsByStudentId(int studentId) throws SQLException {
        String sql = "SELECT id, student_id, marks1, marks2, marks3 FROM results WHERE student_id = ?";
        List<Result> list = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Result(rs.getInt("id"), rs.getInt("student_id"), rs.getInt("marks1"), rs.getInt("marks2"), rs.getInt("marks3")));
                }
            }
        }
        return list;
    }

    public boolean updateResult(Result r) throws SQLException {
        String sql = "UPDATE results SET marks1 = ?, marks2 = ?, marks3 = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, r.getMarks1());
            ps.setInt(2, r.getMarks2());
            ps.setInt(3, r.getMarks3());
            ps.setInt(4, r.getId());
            int affected = ps.executeUpdate();
            return affected > 0;
        }
    }

    public boolean deleteResult(int id) throws SQLException {
        String sql = "DELETE FROM results WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected > 0;
        }
    }
}

// ---------- File: Main.java ----------
package srms;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final StudentDAO studentDAO = new StudentDAO();
    private static final ResultDAO resultDAO = new ResultDAO();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Student Result Management System ===");
        while (true) {
            printMenu();
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> viewStudents();
                    case 3 -> updateStudent();
                    case 4 -> deleteStudent();
                    case 5 -> addResult();
                    case 6 -> viewResult();
                    case 7 -> updateResult();
                    case 8 -> deleteResult();
                    case 9 -> { System.out.println("Exiting..."); return; }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer choice.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Add Student\n2. View Students\n3. Update Student\n4. Delete Student\n5. Add Result\n6. View Result by Student ID\n7. Update Result\n8. Delete Result\n9. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addStudent() {
        try {
            System.out.print("Enter ID (int): ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter name: ");
            String name = sc.nextLine().trim();
            System.out.print("Enter course: ");
            String course = sc.nextLine().trim();
            System.out.print("Enter semester (int): ");
            int sem = Integer.parseInt(sc.nextLine().trim());

            Student s = new Student(id, name, course, sem);
            studentDAO.addStudent(s);
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Student not added.");
        }
    }

    private static void viewStudents() {
        try {
            List<Student> list = studentDAO.getAllStudents();
            if (list.isEmpty()) System.out.println("No students found.");
            else list.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private static void updateStudent() {
        try {
            System.out.print("Enter student ID to update: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Student s = studentDAO.getStudentById(id);
            if (s == null) { System.out.println("Student not found."); return; }
            System.out.print("Enter new name (blank to keep): ");
            String name = sc.nextLine().trim();
            if (!name.isEmpty()) s.setName(name);
            System.out.print("Enter new course (blank to keep): ");
            String course = sc.nextLine().trim();
            if (!course.isEmpty()) s.setCourse(course);
            System.out.print("Enter new semester (blank to keep): ");
            String semStr = sc.nextLine().trim();
            if (!semStr.isEmpty()) s.setSemester(Integer.parseInt(semStr));

            boolean ok = studentDAO.updateStudent(s);
            System.out.println(ok ? "Updated." : "Update failed.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
        }
    }

    private static void deleteStudent() {
        try {
            System.out.print("Enter student ID to delete: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            boolean ok = studentDAO.deleteStudent(id);
            System.out.println(ok ? "Deleted." : "Delete failed (not found).");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
        }
    }

    private static void addResult() {
        try {
            System.out.print("Enter result id (int): ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter student id (int): ");
            int sid = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter marks1: ");
            int m1 = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter marks2: ");
            int m2 = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter marks3: ");
            int m3 = Integer.parseInt(sc.nextLine().trim());

            Result r = new Result(id, sid, m1, m2, m3);
            resultDAO.addResult(r);
            System.out.println("Result added.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Result not added.");
        }
    }

    private static void viewResult() {
        try {
            System.out.print("Enter student id to view results: ");
            int sid = Integer.parseInt(sc.nextLine().trim());
            List<Result> list = resultDAO.getResultsByStudentId(sid);
            if (list.isEmpty()) System.out.println("No results found for student " + sid);
            else list.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private static void updateResult() {
        try {
            System.out.print("Enter result id to update: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            // (In a fuller app you'd fetch the result first; here we ask new marks directly)
            System.out.print("Enter new marks1: ");
            int m1 = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter new marks2: ");
            int m2 = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter new marks3: ");
            int m3 = Integer.parseInt(sc.nextLine().trim());
            Result r = new Result();
            r.setId(id);
            r.setMarks1(m1);
            r.setMarks2(m2);
            r.setMarks3(m3);
            boolean ok = resultDAO.updateResult(r);
            System.out.println(ok ? "Result updated." : "Update failed.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
        }
    }

    private static void deleteResult() {
        try {
            System.out.print("Enter result id to delete: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            boolean ok = resultDAO.deleteResult(id);
            System.out.println(ok ? "Deleted." : "Delete failed.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
        }
    }
}

// ---------- File: README & MySQL script ----------
// SQL to create database and tables (run in MySQL):
/*
CREATE DATABASE srms_db;
USE srms_db;

CREATE TABLE students (
  id INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  course VARCHAR(100),
  semester INT
);

CREATE TABLE results (
  id INT PRIMARY KEY,
  student_id INT,
  marks1 INT,
  marks2 INT,
  marks3 INT,
  FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE
);
*/

// ---------- How to run ----------
// 1) Ensure MySQL server is running and create database/tables using the SQL above.
// 2) Update DatabaseManager.USER and PASS to your MySQL credentials if different.
// 3) Add MySQL Connector/J JDBC driver to classpath (mysql-connector-java-X.X.X.jar).
// 4) Compile (from src parent folder):
//    javac -d bin src/srms/*.java
// 5) Run:
//    java -cp "bin;path/to/mysql-connector-java-X.X.X.jar" srms.Main  (Windows example)
//    OR
//    java -cp "bin:path/to/mysql-connector-java-X.X.X.jar" srms.Main  (Linux/Mac)

// Optional improvements you can try:
// - Use auto-increment for IDs instead of manual entry (remove id from INSERTs)
// - Add validation and custom exceptions
// - Build GUI with Swing/JavaFX
// - Move DAOs into interfaces and implement for better testing
// - Use connection pooling (HikariCP)

// This project demonstrates OOP, collections (you can extend DAOs to also maintain ArrayList caches), exception handling, and JDBC CRUD operations.
