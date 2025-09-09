import java.util.*;

public class student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = new int[n][3]; // PCM
        double[][] result = new double[n][3]; // total, avg, percent

        for (int i=0;i<n;i++) {
            scores[i][0]=10+(int)(Math.random()*90);
            scores[i][1]=10+(int)(Math.random()*90);
            scores[i][2]=10+(int)(Math.random()*90);

            int total = scores[i][0]+scores[i][1]+scores[i][2];
            double avg = total/3.0;
            double percent = (total/300.0)*100;

            result[i][0]=total;
            result[i][1]=Math.round(avg*100.0)/100.0;
            result[i][2]=Math.round(percent*100.0)/100.0;
        }

        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\tPercent");
        for (int i=0;i<n;i++) {
            System.out.println((i+1)+"\t"+scores[i][0]+"\t"+scores[i][1]+"\t"+scores[i][2]+"\t"+
                               result[i][0]+"\t"+result[i][1]+"\t"+result[i][2]);
        }
    }
}
