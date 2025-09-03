package String_Level1;

import java.util.Scanner;
public class lowercase {



	    // Method to convert string to lowercase using charAt() and ASCII values
	    public static String toLowerCaseCustom(String str) {
	        StringBuilder result = new StringBuilder();

	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            // Check if character is uppercase (A-Z)
	            if (ch >= 'A' && ch <= 'Z') {
	                // Convert to lowercase by adding 32
	                ch = (char) (ch + 32);
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

	        // Convert to lowercase using the custom method
	        String customLower = toLowerCaseCustom(inputText);

	        // Convert to lowercase using built-in method
	        String builtInLower = inputText.toLowerCase();

	        // Compare both lowercase strings
	        boolean areEqual = compareStringsCharAt(customLower, builtInLower);

	        // Display results
	        System.out.println("Lowercase string from custom method: " + customLower);
	        System.out.println("Lowercase string from built-in method: " + builtInLower);
	        System.out.println("Are both lowercase strings equal? " + areEqual);

	        scanner.close();
	    }
	}



