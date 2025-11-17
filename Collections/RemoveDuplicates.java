import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : list) {
            if (seen.add(num)) {  // add() returns false if element already exists
                result.add(num);
            }
        }

        System.out.println(result);
    }
}

