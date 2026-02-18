class WordSearch {
    private char[][] grid;
    private boolean[][] visited;
    private int rows, cols;    
    public WordSearch(char[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = new char[rows][cols];
        this.visited = new boolean[rows][cols];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    }    
    public boolean searchWord(String word) {
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(searchFrom(i, j, word, 0)) {
                    System.out.println("Word '" + word + "' found!");
                    markPath(i, j, word, 0);
                    printGrid();
                    return true;
                }
            }
        }
        System.out.println("Word not found!");
        return false;
    }    
    private boolean searchFrom(int x, int y, String word, int index) {
        if(index == word.length()) {
            return true;
        }       
        if(x < 0 || x >= rows || y < 0 || y >= cols || 
           visited[x][y] || grid[x][y] != word.charAt(index)) {
            return false;
        }       
        visited[x][y] = true;
        boolean found = searchFrom(x+1, y, word, index+1) ||
                       searchFrom(x-1, y, word, index+1) ||
                       searchFrom(x, y+1, word, index+1) ||
                       searchFrom(x, y-1, word, index+1);
        
        visited[x][y] = false;
        return found;
    }   
    private void markPath(int x, int y, String word, int index) {
        if(index == word.length()) return;
        
        visited[x][y] = true;
        markPath(x+1, y, word, index+1);
        markPath(x-1, y, word, index+1);
        markPath(x, y+1, word, index+1);
        markPath(x, y-1, word, index+1);
    }   
    public void printGrid() {
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(visited[i][j]) {
                    System.out.print("*" + grid[i][j] + "* ");
                } else {
                    System.out.print(" " + grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
class WordSearchMain {
    public static void main(String[] args) {
        char[][] grid = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };       
        WordSearch ws = new WordSearch(grid);
        System.out.println("Grid:");
        ws.printGrid();
        
        ws.searchWord("ABCCED");
        ws.searchWord("SEE");
    }
}
