public class SelectionSortScores {
    public static void main(String[] args) {
        int[] scores = {65, 80, 50, 95, 75};
        
        selectionSort(scores);
        
        System.out.print("Sorted Exam Scores: ");
        for (int s : scores) System.out.print(s + " ");
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
