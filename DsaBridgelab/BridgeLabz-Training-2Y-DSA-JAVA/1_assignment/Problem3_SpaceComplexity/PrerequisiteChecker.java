import java.util.HashSet;

public class PrerequisiteChecker {
    public static void main(String[] args) {
        int[] completedCourses = {101, 102, 201, 205};
        int[] prerequisites = {101, 205};
        int[] missingPrerequisites = {101, 301};

        System.out.println("Check 1 (Nested Loop): " + implementationA(completedCourses, prerequisites));
        System.out.println("Check 1 (HashSet): " + implementationB(completedCourses, prerequisites));
        
        System.out.println("Check 2 (Nested Loop): " + implementationA(completedCourses, missingPrerequisites));
        System.out.println("Check 2 (HashSet): " + implementationB(completedCourses, missingPrerequisites));
    }

    // Implementation A: Nested Loop
    public static boolean implementationA(int[] completedCourses, int[] prerequisites) {
        int n = completedCourses.length;
        int m = prerequisites.length;

        for (int i = 0; i < m; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (prerequisites[i] == completedCourses[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    // Implementation B: Hash Set
    public static boolean implementationB(int[] completedCourses, int[] prerequisites) {
        int n = completedCourses.length;
        int m = prerequisites.length;
        
        HashSet<Integer> completedSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            completedSet.add(completedCourses[i]);
        }

        for (int i = 0; i < m; i++) {
            if (!completedSet.contains(prerequisites[i])) {
                return false;
            }
        }
        return true;
    }
}
