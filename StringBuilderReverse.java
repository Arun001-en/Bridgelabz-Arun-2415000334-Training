public class RotationPoint {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Smallest element is: " + findRotationPoint(arr));
    }

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }
}
