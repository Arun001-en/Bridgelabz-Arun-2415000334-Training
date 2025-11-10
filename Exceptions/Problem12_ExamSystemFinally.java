import java.io.IOException;

class InvalidStudentException extends Exception {
    public InvalidStudentException(String message) { super(message); }
}

public class Problem12_ExamSystemFinally {

    public static void validateStudent(String studentId) throws InvalidStudentException {
        if (studentId == null || !studentId.equals("S123")) {
            throw new InvalidStudentException("Student ID " + studentId + " is not valid.");
        }
        System.out.println("Student " + studentId + " validated.");
    }

    public static void submitExam(String studentId, boolean simulateIOError) throws InvalidStudentException, IOException {
        validateStudent(studentId);
        if (simulateIOError) {
            throw new IOException("Failed to save exam file to disk.");
        }
        System.out.println("Exam submitted for " + studentId);
    }

    public static void main(String[] args) {
        System.out.println("--- Scenario 1: Invalid Student ---");
        try {
            submitExam("S456", false);
        } catch (InvalidStudentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Exam submission process completed.\n");
        }
        
        System.out.println("--- Scenario 2: IO Error ---");
        try {
            submitExam("S123", true);
        } catch (InvalidStudentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Exam submission process completed.\n");
        }
    }
}
