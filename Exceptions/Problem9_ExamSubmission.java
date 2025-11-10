import java.time.LocalDateTime;

class LateSubmissionException extends Exception {
    public LateSubmissionException(String message) { super(message); }
}

class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) { super(message); }
}

public class Problem9_ExamSubmission {

    private static final LocalDateTime DEADLINE = LocalDateTime.of(2025, 11, 3, 14, 0);

    public static void submitExam(String fileName, LocalDateTime submissionTime) throws LateSubmissionException, InvalidFileFormatException {
        if (submissionTime.isAfter(DEADLINE)) {
            throw new LateSubmissionException("Submission is past the deadline.");
        }
        if (fileName == null || !fileName.endsWith(".pdf")) {
            throw new InvalidFileFormatException("Invalid file format. Only .pdf is accepted.");
        }
        System.out.println("Exam submitted successfully: " + fileName);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Attempt 1 (Late):");
            submitExam("exam.pdf", LocalDateTime.now().plusHours(2));
        } catch (LateSubmissionException | InvalidFileFormatException e) {
            System.out.println("Submission failed: " + e.getMessage());
        }

        try {
            System.out.println("Attempt 2 (Wrong format):");
            submitExam("exam.docx", LocalDateTime.now().minusHours(1));
        } catch (LateSubmissionException | InvalidFileFormatException e) {
            System.out.println("Submission failed: " + e.getMessage());
        }
        
        try {
            System.out.println("Attempt 3 (Success):");
            submitExam("final_exam.pdf", LocalDateTime.now());
        } catch (LateSubmissionException | InvalidFileFormatException e) {
            System.out.println("Submission failed: " + e.getMessage());
        }
    }
}
