class Employee {
    private static String companyName = "Tech Solutions Pvt Ltd";
    private static int totalEmployees = 0;

    private final int id;
    private String name;
    private String designation;

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Akshit", "Software Engineer");
        Employee e2 = new Employee(102, "Preeti", "Data Scientist");

        e1.displayEmployeeDetails();
        System.out.println();
        e2.displayEmployeeDetails();

        System.out.println();
        Employee.displayTotalEmployees();
    }
}
