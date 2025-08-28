 import java.util.Scanner;
public class Que7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            while (true) {
                double w = sc.nextDouble();
                if (w <= 0) {
                    continue;
                }
                personData[i][0] = w;
                break;
            }

            while (true) {
                double h = sc.nextDouble();
                if (h <= 0) {
                    continue;
                }
                personData[i][1] = h;
                break;
            }
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            double bmi = personData[i][2];
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        for (int i = 0; i < number; i++) {
            System.out.printf("%-10.2f %-11.2f %-8.2f %s%n",
                    personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }

        sc.close();
    }
}
