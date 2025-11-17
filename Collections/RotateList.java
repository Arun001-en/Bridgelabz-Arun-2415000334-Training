import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;
        rotate(list, rotateBy);
        System.out.println(list);
    }

    static void rotate(List<Integer> list, int n) {
        int size = list.size();
        n = n % size;
        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(list.subList(n, size));
        rotated.addAll(list.subList(0, n));
        list.clear();
        list.addAll(rotated);
    }
}
