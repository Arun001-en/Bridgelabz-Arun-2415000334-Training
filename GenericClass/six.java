import java.util.Arrays;
import java.util.List;

class six {
    static double sumNumbers(List<? extends Number> list) {
        double s=0;
        for(Number n:list) s+=n.doubleValue();
        return s;
    }
    public static void main(String[] args) {
        System.out.println(sumNumbers(Arrays.asList(1,2,3)));
        System.out.println(sumNumbers(Arrays.asList(1.5,2.5,3.0)));
    }
}