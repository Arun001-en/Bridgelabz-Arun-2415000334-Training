public class InsertionSortEmployee {
    public static void main(String[] args) {
        int[] empIds = {105, 102, 109, 101, 107};
        
        insertionSort(empIds);
        
        System.out.print("Sorted IDs: ");
        for (int id : empIds) System.out.print(id + " ");
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
