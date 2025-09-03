package String_Level1;

import java.util.Scanner;
public class uppercase {

	    // Method to convert string to uppercase using charAt() and ASCII values
	    public static String toUpperCaseCustom(String str) {
	        StringBuilder result = new StringBuilder();

	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            // Check if character is lowercase (a-z)
	            if (ch >= 'a' && ch <= 'z') {
	                // Convert to uppercase by subtracting 32
	                ch = (char) (ch - 32);
	            }
	            result.append(ch);
	        }
	        return result.toString();
	    }

	    // Method to compare two strings using charAt()
	    public static boolean compareStringsCharAt(String s1, String s2) {
	        if (s1.length() != s2.length()) {
	            return false;
	        }
	        for (int i = 0; i < s1.length(); i++) {
	            if (s1.charAt(i) != s2.charAt(i)) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the text:");
	        String inputText = scanner.nextLine();

	        // Convert to uppercase using custom method
	        String customUpper = toUpperCaseCustom(inputText);

	        // Convert to uppercase using built-in method
	        String builtInUpper = inputText.toUpperCase();

	        // Compare the two uppercase strings
	        boolean areEqual = compareStringsCharAt(customUpper, builtInUpper);

	        // Display results
	        System.out.println("Uppercase string from custom method: " + customUpper);
	        System.out.println("Uppercase string from built-in method: " + builtInUpper);
	        System.out.println("Are both uppercase strings equal? " + areEqual);

	        scanner.close();
	    }
	}



