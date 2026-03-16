import java.util.HashSet;

public class StringBuilderNoDups {
    public static void main(String[] args) {
        String input = "programming";
        System.out.println("Result: " + removeDuplicates(input));
    }

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
