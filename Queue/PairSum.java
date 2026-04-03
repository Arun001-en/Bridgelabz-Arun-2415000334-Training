import java.util.*;

public class PairSum {
    public static void main(String[] args) {
        int arr[] = {10, 15, 3, 7};
        int target = 17;

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) {
                System.out.println("Pair Found");
                return;
            }
            set.add(num);
        }
    }
}