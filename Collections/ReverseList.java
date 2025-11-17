import java.util.*;

public class ReverseList {
    public static void main(String[] args) {
        
        List<Integer> arrList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseList(arrList);
        System.out.println("Reversed ArrayList: " + arrList);

        
        List<Integer> linkList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseList(linkList);
        System.out.println("Reversed LinkedList: " + linkList);
    }

    static <T> void reverseList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
}
