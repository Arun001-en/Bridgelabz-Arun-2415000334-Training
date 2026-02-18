class WordSearchBacktracking {
    private char[][] grid;
    private boolean[][] visited;
    private int rows, cols;
    
    public WordSearchBacktracking(char[][] g) {
        grid = g;
        rows = g.length;
        cols = g[0].length;
    }
    
    public boolean findWord(String word) {
        visited = new boolean[rows][cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == word.charAt(0)) {
                    if(searchRecursive(i, j, word, 0)) {
                        printPath();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean searchRecursive(int x, int y, String word, int idx) {
        if(idx == word.length()) return true;
        
        if(x<0 || x>=rows || y<0 || y>=cols || 
           visited[x][y] || grid[x][y] != word.charAt(idx)) {
            return false;
        }
        
        visited[x][y] = true;
        
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        for(int[] dir : directions) {
            if(searchRecursive(x+dir[0], y+dir[1], word, idx+1)) {
                return true;
            }
        }
        
        visited[x][y] = false;  // BACKTRACK
        return false;
    }
    
    private void printPath() {
        System.out.print("Path: ");
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(visited[i][j]) {
                    System.out.print("("+i+","+j+") ");
                }
            }
        }
        System.out.println();
    }
}
class Main {
    public static void main(String[] args) {
        char[][] grid = {
            {'G','S','T','L','E'},
            {'O','R','E','A','M'},
            {'D','R','E','A','M'}
        };
        
        WordSearchBacktracking ws = new WordSearchBacktracking(grid);
        System.out.println("Searching for DREAM...");
        ws.findWord("DREAM");
    }
}
