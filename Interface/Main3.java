interface Payment {
    void pay(double amount);
}

class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}

class CreditCard implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class Wallet implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Wallet.");
    }
}
public class Main3{
    public static void main(String[] args) {
        Payment upi = new UPI();
        Payment credit = new CreditCard();
        Payment wallet = new Wallet();

        upi.pay(250.50);
        credit.pay(1200.00);
        wallet.pay(500.75);
    }
}
