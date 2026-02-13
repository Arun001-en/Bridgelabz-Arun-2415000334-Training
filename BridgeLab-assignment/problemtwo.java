public class problemtwo {

    static int[] rowDir = {-1,-1,-1,0,0,1,1,1};
    static int[] colDir = {-1,0,1,-1,1,-1,0,1};

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        for (int d = 0; d < 8; d++) {
            if (dfs(board, word, row + rowDir[d], col + colDir[d], index + 1, visited)) {
                return true;
            }
        }

        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'C','A','T','S'},
                {'O','R','E','A'},
                {'D','E','A','M'},
                {'E','L','L','S'}
        };

        System.out.println(exist(grid, "DREAM"));
    }
}
