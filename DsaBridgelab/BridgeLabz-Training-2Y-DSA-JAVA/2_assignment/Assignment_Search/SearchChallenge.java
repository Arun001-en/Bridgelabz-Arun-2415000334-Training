import java.util.Arrays;
import java.util.HashSet;

public class SearchChallenge {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + firstMissingPositive(nums));
        
        int[] sortedNums = {1, 3, 5, 7, 9};
        System.out.println("Index of 7: " + binarySearch(sortedNums, 7));
    }

    // Linear Search Logic using Set
    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        
        int i = 1;
        while (true) {
            if (!set.contains(i)) return i;
            i++;
        }
    }

    // Binary Search Logic
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
