class Book {
    int id;
    String title;
    String author;
    String genre;
    boolean available;
    Book next;
    Book prev;

    Book(int id, String title, String author, String genre, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagementSystem {
    private Book head;

    public LibraryManagementSystem() {
        head = null;
    }

    public void addBookAtBeginning(Book newBook) {
        newBook.next = head;
        if (head != null) {
            head.prev = newBook;
        }
        head = newBook;
    }

    public void addBookAtEnd(Book newBook) {
        if (head == null) {
            head = newBook;
            return;
        }
        Book current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newBook;
        newBook.prev = current;
    }

    public void addBookAtPosition(Book newBook, int position) {
        if (position <= 1) {
            addBookAtBeginning(newBook);
            return;
        }
        Book current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            addBookAtEnd(newBook);
            return;
        }
        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) {
            current.next.prev = newBook;
        }
        current.next = newBook;
    }

    public boolean removeBookByID(int id) {
        if (head == null) return false;
        if (head.id == id) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return true;
        }
        Book current = head;
        while (current != null && current.id != id) {
            current = current.next;
        }
        if (current == null) return false;
        current.prev.next = current.next;
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        return true;
    }

    public void searchByTitle(String title) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.printf("Book ID: %d, Title: %s, Author: %s, Genre: %s, Available: %s\n",
                    current.id, current.title, current.author, current.genre, current.available ? "Yes" : "No");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void searchByAuthor(String author) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.printf("Book ID: %d, Title: %s, Author: %s, Genre: %s, Available: %s\n",
                    current.id, current.title, current.author, current.genre, current.available ? "Yes" : "No");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Author not found.");
        }
    }

    public void updateAvailability(int id, boolean status) {
        Book current = head;
        while (current != null) {
            if (current.id == id) {
                current.available = status;
                System.out.println("Availability updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    public int countTotalBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void displayAllBooks() {
        Book current = head;
        System.out.println("All Books:");
        while (current != null) {
            System.out.printf("ID: %d, Title: %s, Author: %s, Genre: %s, Available: %s\n",
                current.id, current.title, current.author, current.genre, current.available ? "Yes" : "No");
            current = current.next;
        }
    }

    public void displayInReverse() {
        if (head == null) {
            System.out.println("No books to display.");
            return;
        }
        Book current = head;
        while (current.next != null) {
            current = current.next;
        }
        System.out.println("Books in Reverse Order:");
        while (current != null) {
            System.out.printf("ID: %d, Title: %s, Author: %s, Genre: %s, Available: %s\n",
                current.id, current.title, current.author, current.genre, current.available ? "Yes" : "No");
            current = current.prev;
        }
    }
}

class Main {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        
        library.addBookAtBeginning(new Book(1, "Java Programming", "John Smith", "Tech", true));
        library.addBookAtEnd(new Book(2, "Data Structures", "Jane Doe", "Tech", false));
        library.addBookAtPosition(new Book(3, "Algorithms", "Alan Turing", "Tech", true), 2);
        
        library.displayAllBooks();
        System.out.println("\nTotal books: " + library.countTotalBooks());
        
        library.searchByTitle("Java Programming");
        library.searchByAuthor("Jane Doe");
        
        library.updateAvailability(2, true);
        
        library.displayInReverse();
        
        library.removeBookByID(3);
        System.out.println("\nAfter removing book ID 3:");
        library.displayAllBooks();
        System.out.println("Total books: " + library.countTotalBooks());
    }
}
