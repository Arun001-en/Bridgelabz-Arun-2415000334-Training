abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    public int getEmployeeId(){ return employeeId; }
    public void setEmployeeId(int id){ this.employeeId = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public double getBaseSalary(){ return baseSalary; }
    public void setBaseSalary(double s){ this.baseSalary = s; }
    public void displayDetails(){ System.out.println(employeeId+" "+name+" "+calculateSalary()); }
    public abstract double calculateSalary();
}
interface Department {
    void assignDepartment(String d);
    String getDepartmentDetails();
}
class FullTimeEmployee extends Employee implements Department {
    private double allowance;
    private String department;
    public void setAllowance(double a){ this.allowance = a; }
    @Override
    public double calculateSalary(){ return getBaseSalary() + allowance; }
    @Override
    public void assignDepartment(String d){ this.department = d; }
    @Override
    public String getDepartmentDetails(){ return department; }
}
class PartTimeEmployee extends Employee {
    private int hours;
    private double hourlyRate;
    public void setHours(int h){ this.hours = h; }
    public void setHourlyRate(double r){ this.hourlyRate = r; }
    @Override
    public double calculateSalary(){ return hours * hourlyRate; }
}
public class EmployeeSystem {
    public static void main(String[] args){
        Employee[] arr = new Employee[2];
        FullTimeEmployee f = new FullTimeEmployee();
        f.setEmployeeId(1); f.setName("Ravi"); f.setBaseSalary(50000); f.setAllowance(5000); f.assignDepartment("HR");
        PartTimeEmployee p = new PartTimeEmployee();
        p.setEmployeeId(2); p.setName("Asha"); p.setHourlyRate(200); p.setHours(80);
        arr[0]=f; arr[1]=p;
        for(Employee e: arr) e.displayDetails();
        System.out.println(((FullTimeEmployee)f).getDepartmentDetails());
    }
}
