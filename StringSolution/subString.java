package String_Level1;

import java.util.Scanner;
public class subString {

	    // Method to create a substring using charAt()
	    public static String createSubstringCharAt(String str, int start, int end) {
	        StringBuilder substring = new StringBuilder();
	        // Append characters from start to end-1
	        for (int i = start; i < end; i++) {
	            substring.append(str.charAt(i));
	        }
	        return substring.toString();
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

	        System.out.println("Enter the original string:");
	        String originalString = scanner.next();

	        System.out.println("Enter the start index:");
	        int startIndex = scanner.nextInt();

	        System.out.println("Enter the end index:");
	        int endIndex = scanner.nextInt();

	        // Create substring using charAt method
	        String substringCharAt = createSubstringCharAt(originalString, startIndex, endIndex);

	        // Create substring using built-in substring method
	        String substringBuiltIn = originalString.substring(startIndex, endIndex);

	        // Compare both substrings using the custom compare method
	        boolean areEqual = compareStringsCharAt(substringCharAt, substringBuiltIn);

	        // Display results
	        System.out.println("Substring created using charAt(): " + substringCharAt);
	        System.out.println("Substring created using built-in substring(): " + substringBuiltIn);
	        System.out.println("Are both substrings equal (using custom compare)? " + areEqual);

	        scanner.close();
	    }
	}



