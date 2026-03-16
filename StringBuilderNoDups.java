public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println("Peak Element: " + findPeak(arr));
    }

    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left];
    }
}
