package Inheritance;

class EmployeeDetails{
	String name;
	int id;
	double salary;
	EmployeeDetails(String name, int id, double salary ){
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	 void displayDetails() {
		System.out.println("The name of employee is :"+name);
		System.out.println("The id of employee is:"+id);
		System.out.println("The salary of employee is:"+salary);
			
	}
	 
}

class ManagerDetails extends EmployeeDetails{
	int teamSize;
	ManagerDetails(String name, int id, double salary,int teamSize){
		super(name,id,salary);
		this.teamSize = teamSize;
		
	}
	void displayDetails() {
		System.out.println("The name of manager is :"+name);
		System.out.println("The id of manager is:"+id);
		System.out.println("The salary of manager is:"+salary);
		System.out.println("The teamsize of manager is:"+teamSize);
			
	}
}

class Developer extends EmployeeDetails{
	String programmingLanguage;
	Developer(String name, int id, double salary,String programmingLanguage){
		super(name,id,salary);
		this.programmingLanguage = programmingLanguage;
	}
	 void displayDetails() {
			System.out.println("The name of developer is :"+name);
			System.out.println("The id of developer is:"+id);
			System.out.println("The salary of developer is:"+salary);
			System.out.println("The programming language of developer is:"+programmingLanguage);
				
		}
}

class Intern extends EmployeeDetails{
	
	Intern(String name, int id, double salary){
		super(name,id,salary);
		
	}
	 void displayDetails() {
			System.out.println("The name of intern is :"+name);
			System.out.println("The id of intern is:"+id);
			System.out.println("The salary of intern is:"+salary);
			
			
		}
}

public class EmployeeManagement {


	public static void main(String[] args) {
		ManagerDetails manager = new ManagerDetails("Anuj",123,1,12345);
		Developer developer = new Developer("hemant",345,2,"Java");
		Intern intern = new Intern("Madhav",890,3);
		
		manager.displayDetails();
		developer.displayDetails();
		intern.displayDetails();
		
	}

}