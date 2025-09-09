import java.util.*;

public class calender {
    static String[] months = {"January","February","March","April","May","June","July",
                              "August","September","October","November","December"};
    static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getFirstDay(int month, int year) {
        int d = 1, y = year, m = month;
        if (m < 3) { m += 12; y--; }
        int k = y % 100;
        int j = y / 100;
        int h = (d + (13*(m+1))/5 + k + k/4 + j/4 + 5*j) % 7;
        return (h + 6) % 7; // 0=Sunday
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = Integer.parseInt(sc.nextLine());
        System.out.print("Enter year: ");
        int year = Integer.parseInt(sc.nextLine());

        int numDays = days[month-1];
        if (month == 2 && isLeapYear(year)) numDays = 29;

        int firstDay = getFirstDay(month, year);

        System.out.println("\n   " + months[month-1] + " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) System.out.print("    ");
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%4d", day);
            if ((day + firstDay) % 7 == 0) System.out.println();
        }
    }
}
