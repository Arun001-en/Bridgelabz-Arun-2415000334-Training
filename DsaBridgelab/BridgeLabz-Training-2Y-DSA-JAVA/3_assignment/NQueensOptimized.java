import java.util.Arrays;

public class NQueensOptimized {
    public static void main(String[] args) {
        int n = 4; // Can be changed to 8
        System.out.println("Solving N-Queens for N=" + n);
        solveNQueens(n);
    }

    public static void solveNQueens(int n) {
        // 1D array to store queen positions: board[row] = col
        int[] board = new int[n];
        
        // Lookup arrays for fast safety checks
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // Main diagonal
        boolean[] diag2 = new boolean[2 * n - 1]; // Anti-diagonal
        
        solve(0, n, board, cols, diag1, diag2);
    }

    public static void solve(int row, int n, int[] board, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        // Base Case: All queens placed
        if (row == n) {
            printSolution(board);
            return;
        }

        // Try every column for the current row
        for (int col = 0; col < n; col++) {
            // Check if position is safe using O(1) lookups
            if (!cols[col] && !diag1[row - col + n - 1] && !diag2[row + col]) {
                
                // Place Queen
                board[row] = col;
                cols[col] = true;
                diag1[row - col + n - 1] = true;
                diag2[row + col] = true;

                // Recurse to next row
                solve(row + 1, n, board, cols, diag1, diag2);

                // Backtrack (Remove Queen)
                cols[col] = false;
                diag1[row - col + n - 1] = false;
                diag2[row + col] = false;
            }
        }
    }

    public static void printSolution(int[] board) {
        int n = board.length;
        System.out.println("Solution found: " + Arrays.toString(board));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) System.out.print("Q ");
                else System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
