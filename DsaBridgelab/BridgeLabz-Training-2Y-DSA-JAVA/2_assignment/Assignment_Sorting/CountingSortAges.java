import java.util.Arrays;

public class CountingSortAges {
    public static void main(String[] args) {
        // Ages range 10-18
        int[] ages = {12, 18, 15, 12, 10, 16, 18, 15};
        
        countingSort(ages);
        
        System.out.println("Sorted Ages: " + Arrays.toString(ages));
    }

    public static void countingSort(int[] arr) {
        int max = 18;
        int min = 10;
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
