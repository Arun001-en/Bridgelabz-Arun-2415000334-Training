class RatInMaze {
    private int[][] maze;
    private int[][] solution;
    private int rows, cols;    
    public RatInMaze(int[][] maze) {
        this.rows = maze.length;
        this.cols = maze[0].length;
        this.maze = new int[rows][cols];
        this.solution = new int[rows][cols];        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                this.maze[i][j] = maze[i][j];
                this.solution[i][j] = 0;
            }
        }
    }   
    public boolean solveMaze() {
        if(solve(0, 0)) {
            printSolution();
            return true;
        }
        return false;
    }   
    private boolean solve(int x, int y) {
        if(x == rows-1 && y == cols-1) {
            solution[x][y] = 1;
            return true;
        }        
        if(isValidMove(x, y)) {
            solution[x][y] = 1;
            
            if(solve(x+1, y)) return true;
            if(solve(x, y+1)) return true;
            if(solve(x-1, y)) return true;
            if(solve(x, y-1)) return true;
            
            solution[x][y] = 0;
            return false;
        }
        return false;
    }    
    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols && 
               maze[x][y] == 1 && solution[x][y] == 0;
    }   
    public void printSolution() {
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }    
    public void printMaze() {
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class MazeMain {
    public static void main(String[] args) {
        int[][] maze = {
            {1,0,0,0},
            {1,1,0,1},
            {0,1,0,0},
            {1,1,1,1}
        };        
        RatInMaze rat = new RatInMaze(maze);
        System.out.println("Original Maze:");
        rat.printMaze();
        
        System.out.println("\nSolution Path:");
        rat.solveMaze();
    }
}
