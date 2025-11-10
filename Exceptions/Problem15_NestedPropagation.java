public class Problem15_NestedPropagation {

    public static void methodB() {
        System.out.println("Inside methodB");
        try {
            System.out.println("Trying to parse 'abc'...");
            Integer.parseInt("abc");
            System.out.println("This won't print.");
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException inside methodB.");
        }
        
        System.out.println("Creating NullPointerException...");
        String s = null;
        s.length(); 
    }

    public static void methodA() {
        System.out.println("Inside methodA");
        try {
            methodB();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException inside methodA.");
        }
        System.out.println("Exiting methodA");
    }

    public static void main(String[] args) {
        methodA();
    }
}
