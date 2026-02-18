class GraphColoring {
    private int vertices;
    private int[][] adjMatrix;
    private int[] color;
    private int numColors;
    
    public GraphColoring(int v, int[][] matrix) {
        this.vertices = v;
        this.adjMatrix = matrix;
        this.color = new int[v];
        this.numColors = 3;
    }
    
    public boolean solveGraphColoring() {
        return graphColoringUtil(0);
    }
    
    private boolean graphColoringUtil(int v) {
        if(v == vertices) {
            return true;
        }
        
        for(int c=1; c<=numColors; c++) {
            if(isSafe(v, c)) {
                color[v] = c;
                
                if(graphColoringUtil(v+1)) {
                    return true;
                }
                
                color[v] = 0;
            }
        }
        return false;
    }
    
    private boolean isSafe(int vertex, int c) {
        for(int i=0; i<vertices; i++) {
            if(adjMatrix[vertex][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }
    
    public void printSolution() {
        System.out.println("Vertex Colors:");
        for(int i=0; i<vertices; i++) {
            System.out.println("V" + i + " -> Color " + color[i]);
        }
    }
}

class GraphColorMain {
    public static void main(String[] args) {
        int vertices = 4;
        int[][] graph = {
            {0,1,1,1},
            {1,0,1,0},
            {1,1,0,1},
            {1,0,1,0}
        };
        
        GraphColoring gc = new GraphColoring(vertices, graph);
        
        System.out.println("Graph Coloring Problem (3 colors)");
        if(gc.solveGraphColoring()) {
            System.out.println("Solution found:");
            gc.printSolution();
        } else {
            System.out.println("No solution exists with 3 colors!");
        }
    }
}
