public class QuickSortProducts {
    public static void main(String[] args) {
        double[] prices = {49.99, 19.99, 99.99, 29.99, 9.99};
        
        quickSort(prices, 0, prices.length - 1);
        
        System.out.print("Sorted Product Prices: ");
        for (double p : prices) System.out.print(p + " ");
    }

    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
