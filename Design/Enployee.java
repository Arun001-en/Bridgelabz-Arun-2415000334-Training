package constructors;
class Employee {
    public int employeeID;        // Public → Accessible anywhere
    protected String department;  // Protected → Accessible in same package + subclasses
    private double salary;        // Private → Accessible only inside this class

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Setter method to modify salary
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("❌ Salary cannot be negative!");
        }
    }

    // Getter method to access salary
    public double getSalary() {
        return salary;
    }

    // Display Employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + salary);
    }
}
