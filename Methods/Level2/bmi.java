import java.util.*;

public class bmi{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3]; // weight, height, BMI

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            double weight = Double.parseDouble(sc.nextLine());

            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            double heightCm = Double.parseDouble(sc.nextLine());

            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);

            data[i][0] = weight;
            data[i][1] = heightCm;
            data[i][2] = bmi;
        }

        System.out.println("\n--- BMI Results ---");
        for (int i = 0; i < 10; i++) {
            String status;
            if (data[i][2] < 18.5) status = "Underweight";
            else if (data[i][2] < 24.9) status = "Normal";
            else if (data[i][2] < 29.9) status = "Overweight";
            else status = "Obese";

            System.out.println("Person " + (i + 1) + " -> Weight: " + data[i][0] +
                               " kg, Height: " + data[i][1] +
                               " cm, BMI: " + String.format("%.2f", data[i][2]) +
                               ", Status: " + status);
        }
        sc.close();
    }
}
