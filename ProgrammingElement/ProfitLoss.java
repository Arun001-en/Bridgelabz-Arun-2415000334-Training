import java.util.Scanner;
public class ProfitLoss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cp = 129;
        int sp = 191;
        int profit = sp-cp;
        System.out.println("The profit in number is:"+profit);
        int loss = cp-sp;
        System.out.println("The loss in number is:"+loss);
        double percentage = profit/cp*100;
        System.out.println(percentage);
    }
}
