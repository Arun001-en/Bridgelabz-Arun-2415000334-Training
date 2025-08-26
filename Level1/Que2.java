import java.util.Scanner;
public class Que2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a>b && a>c){
            System.out.println("A is Greater");
        }
        else if(b>a && b>c){
            System.out.println("B is Greater");
        }
        else{
            System.out.println("C is greater");
        }
    }
}
