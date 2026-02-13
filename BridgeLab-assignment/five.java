package array;

import java.util.Scanner;

public class five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] result = new int[4];

        int index = 0;
        for (int i = 6; i <= 9; i++) {
            result[index] = number * i;
            index++;
        }

        index = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + result[index]);
            index++;
        }
    }
}

