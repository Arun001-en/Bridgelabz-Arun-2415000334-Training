class NQueens {
    private int n;
    private int[] queens;  
    public NQueens(int size) {
        n = size;
        queens = new int[n];
    }    
    public boolean solveNQueens() {
        return placeQueens(0);
    }    
    private boolean placeQueens(int row) {
        if(row == n) {
            printSolution();
            return true; 
        }
        
        for(int col=0; col<n; col++) {
            if(isSafe(row, col)) {
                queens[row] = col;
                
                if(placeQueens(row+1)) {
                    return true;
                }
                
                queens[row] = -1;
            }
        }
        return false;
    }   
    private boolean isSafe(int row, int col) {
        for(int prevRow=0; prevRow<row; prevRow++) {
            int prevCol = queens[prevRow];
            
            if(prevCol == col) return false;
            if(Math.abs(prevCol - col) == (row - prevRow)) return false;
        }
        return true;
    }   
    private void printSolution() {
        for(int i=0; i<n; i++) {
            System.out.print("Q");
            for(int j=0; j<n; j++) {
                System.out.print(j == queens[i] ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
