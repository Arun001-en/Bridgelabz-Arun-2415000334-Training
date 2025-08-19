public class Question6 {
    public static void main(String[] args) {
        int fee = 125000;
        int dP = 10; 
        int discount = (fee * dP) / 100;
        int fF = fee - discount;
        System.out.println("The discount amount is Inr " + discount + 
                           " and final discounted fee is Inr " + fF);
    }
}
