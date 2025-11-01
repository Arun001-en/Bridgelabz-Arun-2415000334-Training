public class Que5 {
     public static void main(String[] args) {
        
        int num = Integer.parseInt("123");
        System.out.println("Integer.parseInt(\"123\") = " + num);

        double pi = Double.parseDouble("3.14");
        System.out.println("Double.parseDouble(\"3.14\") = " + pi);

       
        boolean flag = Boolean.parseBoolean("true");
        System.out.println("Boolean.parseBoolean(\"true\") = " + flag);

       
        String binary = Integer.toBinaryString(10);
        System.out.println("Integer.toBinaryString(10) = " + binary);

        boolean isDigit = Character.isDigit('5');
        System.out.println("Character.isDigit('5') = " + isDigit);
    }
}
