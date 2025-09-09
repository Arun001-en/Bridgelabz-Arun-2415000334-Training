import java.util.*;

public class employee_bonus {
    public static void main(String[] args) {
        double[][] data = new double[10][4]; // salary, years, bonus, newSalary
        double totalOld=0, totalNew=0, totalBonus=0;

        for (int i = 0; i < 10; i++) {
            double salary = 10000 + (int)(Math.random() * 90000);
            int years = 1 + (int)(Math.random() * 15);

            double bonusRate = (years > 5) ? 0.05 : 0.02;
            double bonus = salary * bonusRate;
            double newSalary = salary + bonus;

            data[i][0]=salary;
            data[i][1]=years;
            data[i][2]=bonus;
            data[i][3]=newSalary;

            totalOld += salary;
            totalNew += newSalary;
            totalBonus += bonus;
        }

        System.out.println("Emp\tSalary\tYears\tBonus\tNewSalary");
        for (int i=0;i<10;i++) {
            System.out.printf("%d\t%.0f\t%.0f\t%.0f\t%.0f\n",
                              i+1,data[i][0],data[i][1],data[i][2],data[i][3]);
        }
        System.out.println("Total Old Salary: " + totalOld);
        System.out.println("Total New Salary: " + totalNew);
        System.out.println("Total Bonus Paid: " + totalBonus);
    }
}
