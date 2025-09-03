package string_Level2;

import java.util.Scanner;
public class length {

	    public static int getLengthWithoutLengthMethod(String str) {
	        int length = 0;
	        try {
	            while (true) {
	                str.charAt(length);
	                length++;
	            }
	        } catch (IndexOutOfBoundsException e) {
	            return length;
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter a string:");
	        String input = scanner.next();

	        int lengthCustom = getLengthWithoutLengthMethod(input);
	        int lengthBuiltIn = input.length();

	        System.out.println("Length from custom method: " + lengthCustom);
	        System.out.println("Length from built-in length() method: " + lengthBuiltIn);

	        scanner.close();
	    }
	}



