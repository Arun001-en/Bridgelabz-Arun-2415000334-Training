public class Que10 {
   
    public static boolean validateAge(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput); 
            return age >= 18; 
        } catch (NumberFormatException e) {
            return false; 
        }
    }
    public static void main(String[] args) {
        System.out.println(validateAge("20"));  
        System.out.println(validateAge("17"));
        System.out.println(validateAge("abc"));
        System.out.println(validateAge("18"));
    }
}
