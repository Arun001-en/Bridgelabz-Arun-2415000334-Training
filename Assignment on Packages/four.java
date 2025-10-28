

import java.time.LocalDate;


class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isIssued;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isIssued = false;
    }

    public void markIssued() {
        isIssued = true;
    }

    public void markReturned() {
        isIssued = false;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public String getTitle() {
        return title;
    }

    public void displayBookInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Status: " + (isIssued ? "Issued" : "Available"));
    }
}


class Member {
    private String name;
    private int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void displayMemberInfo() {
        System.out.println("Member Name: " + name);
        System.out.println("Member ID: " + memberId);
    }
}


class Transaction {
    private Book book;
    private Member member;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public void issueBook(Book book, Member member) {
        if (book.isIssued()) {
            System.out.println("Sorry, this book is already issued.");
        } else {
            this.book = book;
            this.member = member;
            this.issueDate = LocalDate.now();
            book.markIssued();
            System.out.println(" Book '" + book.getTitle() + "' issued to " 
                               + member.getName() + " on " + issueDate);
        }
    }

    public void returnBook() {
        if (book != null && book.isIssued()) {
            book.markReturned();
            this.returnDate = LocalDate.now();
            System.out.println(" Book '" + book.getTitle() + "' returned by " 
                               + member.getName() + " on " + returnDate);
        } else {
            System.out.println(" No active transaction to return.");
        }
    }
}


public class four{
    public static void main(String[] args) {
        
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        System.out.println("=== New Book Added ===");
        book1.displayBookInfo();

        Member member1 = new Member("Alice Johnson", 101);
        System.out.println("\n=== New Member Registered ===");
        member1.displayMemberInfo();

        
        System.out.println("\n=== Transaction ===");
        Transaction transaction = new Transaction();
        transaction.issueBook(book1, member1);

        
        System.out.println("\n=== Returning Book ===");
        transaction.returnBook();
    }
}
