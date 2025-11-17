import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> diff = new HashSet<>(set1);
        diff.addAll(set2);

        Set<Integer> temp = new HashSet<>(set1);
        temp.retainAll(set2);

        diff.removeAll(temp);

        System.out.println("Symmetric Difference: " + diff);
    }
}

