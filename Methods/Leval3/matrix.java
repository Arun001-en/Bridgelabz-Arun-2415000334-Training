import java.util.*;

public class matrix {
    public static int[][] createMatrix(int r,int c) {
        int[][] m = new int[r][c];
        for (int i=0;i<r;i++)
            for (int j=0;j<c;j++)
                m[i][j]=(int)(Math.random()*10);
        return m;
    }

    public static int[][] add(int[][] a,int[][] b) {
        int r=a.length,c=a[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                res[i][j]=a[i][j]+b[i][j];
        return res;
    }

    public static int[][] sub(int[][] a,int[][] b) {
        int r=a.length,c=a[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                res[i][j]=a[i][j]-b[i][j];
        return res;
    }

    public static int[][] mul(int[][] a,int[][] b) {
        int r=a.length, c=b[0].length, n=b.length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                for(int k=0;k<n;k++)
                    res[i][j]+=a[i][k]*b[k][j];
        return res;
    }

    public static void display(int[][] m) {
        for(int[] row:m){
            for(int val:row) System.out.print(val+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a=createMatrix(2,2);
        int[][] b=createMatrix(2,2);

        System.out.println("Matrix A:"); display(a);
        System.out.println("Matrix B:"); display(b);
        System.out.println("Addition:"); display(add(a,b));
        System.out.println("Subtraction:"); display(sub(a,b));
        System.out.println("Multiplication:"); display(mul(a,b));
    }
}
