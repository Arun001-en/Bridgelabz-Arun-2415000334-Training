public class WordPuzzleGame {
    // 8 Directions: Horiz, Vert, Diag
    static int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        char[][] grid = {
            {'C', 'A', 'T', 'S'},
            {'O', 'R', 'E', 'A'},
            {'D', 'E', 'A', 'M'},
            {'E', 'L', 'L', 'S'}
        };
        String target = "DREAM";
        
        System.out.println("Target Word: " + target);
        boolean found = exist(grid, target);
        System.out.println("Word Found: " + found);
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean backtrack(char[][] board, String word, int r, int c, int index, boolean[][] visited) {
        // Base Case: Word successfully found
        if (index == word.length()) {
            return true;
        }

        // Boundary checks and validation
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || 
            visited[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark path as visited
        visited[r][c] = true;

        // Base Case for successful end of word (last char matched)
        if (index == word.length() - 1) {
            return true;
        }

        // Explore all 8 directions
        for (int d = 0; d < 8; d++) {
            if (backtrack(board, word, r + rowDir[d], c + colDir[d], index + 1, visited)) {
                return true;
            }
        }

        // Backtrack
        visited[r][c] = false;
        return false;
    }
}
