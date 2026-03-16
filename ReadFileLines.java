public class FirstNegative {
    public static void main(String[] args) {
        int[] arr = {10, 20, 5, -3, 8, -1};
        int index = findFirstNegative(arr);
        System.out.println("First negative index: " + index);
    }

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
