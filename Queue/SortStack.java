import java.util.Stack;

public class SortStack {

    static void sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sort(s);
            insert(s, x);
        }
    }

    static void insert(Stack<Integer> s, int x) {
        if (s.isEmpty() || s.peek() <= x) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        insert(s, x);
        s.push(temp);
    }
}