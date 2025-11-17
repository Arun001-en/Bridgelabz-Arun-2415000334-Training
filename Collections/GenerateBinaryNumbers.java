import java.util.*;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        int n = 5;
        generateBinary(n);
    }

    static void generateBinary(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String front = queue.remove();
            System.out.println(front);
            queue.add(front + "0");
            queue.add(front + "1");
        }
    }
}
