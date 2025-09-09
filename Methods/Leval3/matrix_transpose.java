import java.util.*;

public class matrix_transpose{
    public static int[][] transpose(int[][] a) {
        int r=a.length,c=a[0].length;
        int[][] t=new int[c][r];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                t[j][i]=a[i][j];
        return t;
    }

    public static int det2x2(int[][] a) {
        return a[0][0]*a[1][1]-a[0][1]*a[1][0];
    }

    public static int det3x3(int[][] a) {
        return a[0][0]*(a[1][1]*a[2][2]-a[1][2]*a[2][1])
             - a[0][1]*(a[1][0]*a[2][2]-a[1][2]*a[2][0])
             + a[0][2]*(a[1][0]*a[2][1]-a[1][1]*a[2][0]);
    }

    public static double[][] inv2x2(int[][] a) {
        double det=det2x2(a);
        double[][] inv=new double[2][2];
        inv[0][0]=a[1][1]/det; inv[0][1]=-a[0][1]/det;
        inv[1][0]=-a[1][0]/det; inv[1][1]=a[0][0]/det;
        return inv;
    }

    public static void display(int[][] m) {
        for(int[] row:m){
            for(int v:row) System.out.print(v+" ");
            System.out.println();
        }
    }
    public static void display(double[][] m) {
        for(double[] row:m){
            for(double v:row) System.out.printf("%.2f ",v);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a={{2,3},{1,4}};
        System.out.println("Matrix:");
        display(a);

        System.out.println("Transpose:");
        display(transpose(a));

        System.out.println("Determinant 2x2: " + det2x2(a));
        System.out.println("Inverse 2x2:");
        display(inv2x2(a));
    }
}
