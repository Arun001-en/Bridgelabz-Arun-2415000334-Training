import java.util.*;

public class MaxValueKey {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A",10,"B",20,"C",15);

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (String k : map.keySet()) {
            if (map.get(k) > maxValue) {
                maxKey = k;
                maxValue = map.get(k);
            }
        }

        System.out.println("Key with highest value = " + maxKey);
    }
}
