public class five {

    
    static class Book {
        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author){
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public void display(){
            System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author);
        }

        public String getTitle() { return title; }
    }

    static class Member {
        private int memberId;
        private String name;

        public Member(int memberId, String name){
            this.memberId = memberId;
            this.name = name;
        }

        public void display(){
            System.out.println("Member ID: " + memberId + ", Name: " + name);
        }

        public String getName() { return name; }
    }

    static class Transaction {
        private Book book;
        private Member member;

        public Transaction(Book book, Member member){
            this.book = book;
            this.member = member;
        }

        public void issue(){
            System.out.println("Issued '" + book.getTitle() + "' to " + member.getName());
        }
    }

   
    static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary){
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }

        public void display(){
            System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
        }
    }

    static class Payroll {
        public double calculateBonus(Employee e){
            double bonus = e.getSalary() * 0.10;
            e.setSalary(e.getSalary() + bonus);
            return e.getSalary();
        }
    }

   
    public static void main(String[] args) {

        System.out.println("=== Library Management System ===");
        Book book1 = new Book(101, "Java Programming", "John Doe");
        Member member1 = new Member(1, "Alice");
        Transaction transaction1 = new Transaction(book1, member1);

        book1.display();
        member1.display();
        transaction1.issue();

        
        System.out.println("\n=== Employee Management System ===");
        Employee emp1 = new Employee(1, "Bob", "IT", 50000);
        emp1.display();

        Payroll payroll = new Payroll();
        double newSalary = payroll.calculateBonus(emp1);
        System.out.println("Salary after bonus: " + newSalary);
    }
}
