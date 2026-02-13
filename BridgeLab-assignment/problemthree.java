public class problemthree {

    static int[] board;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void solve(int n) {
        board = new int[n];
        col = new boolean[n];
        diag1 = new boolean[2*n];
        diag2 = new boolean[2*n];
        backtrack(0, n);
    }

    private static boolean backtrack(int row, int n) {
        if (row == n) {
            printBoard(n);
            return true;
        }

        for (int c = 0; c < n; c++) {
            if (!col[c] && !diag1[row + c] && !diag2[row - c + n]) {
                board[row] = c;
                col[c] = true;
                diag1[row + c] = true;
                diag2[row - c + n] = true;

                if (backtrack(row + 1, n)) {
                    return true;
                }

                col[c] = false;
                diag1[row + c] = false;
                diag2[row - c + n] = false;
            }
        }
        return false;
    }

    private static void printBoard(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve(8);
    }
}

