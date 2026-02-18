class SudokuSolver {
    private int[][] board = new int[9][9];
    public SudokuSolver(int[][] inputBoard) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                board[i][j] = inputBoard[i][j];
            }
        }
    }
    public boolean solve() {
        return solveSudoku(0, 0);
    }
    private boolean solveSudoku(int row, int col) {
        if(row == 9) {
            return true;
        }     
        int nextRow = row;
        int nextCol = col + 1;
        
        if(nextCol == 9) {
            nextRow++;
            nextCol = 0;
        }
        
        if(board[row][col] != 0) {
            return solveSudoku(nextRow, nextCol);
        }    
        for(int num=1; num<=9; num++) {
            if(isSafe(row, col, num)) {
                board[row][col] = num;
                
                if(solveSudoku(nextRow, nextCol)) {
                    return true;
                }
                
                board[row][col] = 0;
            }
        }
        return false;
    }
    private boolean isSafe(int row, int col, int num) {
        for(int x=0; x<9; x++) {
            if(board[row][x] == num) return false;
        }
        
        for(int x=0; x<9; x++) {
            if(board[x][col] == num) return false;
        }
        
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[i+startRow][j+startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    public void printSolution() {
        for(int i=0; i<9; i++) {
            if(i%3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for(int j=0; j<9; j++) {
                if(j%3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Main {
    public static void main(String[] args) {
        int[][] sudoku = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        }; 
        SudokuSolver solver = new SudokuSolver(sudoku);
        
        System.out.println("Unsolved:");
        solver.printSolution();
        
        if(solver.solve()) {
            System.out.println("\nSolved:");
            solver.printSolution();
        } else {
            System.out.println("No solution!");
        }
    }
}
