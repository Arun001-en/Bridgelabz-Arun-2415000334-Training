package String_Level1;

public class compare {

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

	        System.out.println("Enter first string:");
	        String string1 = scanner.next();

	        System.out.println("Enter second string:");
	        String string2 = scanner.next();

	        
	        boolean customResult = compareStringsCharAt(string1, string2);

	        
	        boolean builtInResult = string1.equals(string2);

	        
	        System.out.println("Comparison result using charAt method: " + customResult);
	        System.out.println("Comparison result using built-in equals method: " + builtInResult);

	       
	        if (customResult == builtInResult) {
	            System.out.println("Both methods produce the same result.");
	        } else {
	            System.out.println("Methods produce different results.");
	        }

	        scanner.close();
	    }
	}

