public class Problem2_GradeParser {
    public static void main(String[] args) {
        String[] grades = {"90", "A+", "85", "72", "B-"};

        System.out.println("Parsing student grades:");
        for (String grade : grades) {
            try {
                int numericGrade = Integer.parseInt(grade);
                System.out.println("Parsed grade: " + numericGrade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade input: " + grade);
            }
        }
    }
}
