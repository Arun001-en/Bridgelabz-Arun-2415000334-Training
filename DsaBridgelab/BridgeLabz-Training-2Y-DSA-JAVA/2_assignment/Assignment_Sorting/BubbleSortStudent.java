public class BubbleSortStudent {
    public static void main(String[] args) {
        int[] marks = {85, 92, 76, 64, 99, 55, 88};
        
        System.out.print("Original Marks: ");
        printArray(marks);

        bubbleSort(marks);

        System.out.print("Sorted Marks: ");
        printArray(marks);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
