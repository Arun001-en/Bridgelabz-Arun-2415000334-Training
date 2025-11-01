public class Que6 {
    public static int safeParseInt(String input) {
        try {
            return Integer.parseInt(input); 
        } catch (NumberFormatException e) {
            return -1;  
        }
    }

    public static void main(String[] args) {
        // Test inputs
        String[] testInputs = {"123", "abc", "45.6", "0"};

        for (String input : testInputs) {
            int result = safeParseInt(input);
            System.out.println("Input: \"" + input + "\" → Output: " + result);
            }    }
}
