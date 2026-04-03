import java.util.*;

public class StockSpan {
    public static void main(String[] args) {
        int price[] = {100, 80, 60, 70, 60, 75, 85};
        int span[] = new int[price.length];

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < price.length; i++) {
            while (!s.isEmpty() && price[s.peek()] <= price[i]) {
                s.pop();
            }

            span[i] = s.isEmpty() ? (i + 1) : (i - s.peek());
            s.push(i);
        }

        System.out.println(Arrays.toString(span));
    }
}