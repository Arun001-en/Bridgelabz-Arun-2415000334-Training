class Movie {
    String title, director;
    int year, rating;
    Movie prev, next;
    
    Movie(String t, String d, int y, int r) {
        title = t; director = d; year = y; rating = r;
    }
}
class DoublyLinkedList {
    Movie head, tail;
    
    void addMovie(String title, String director, int year, int rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }   
    void addMovieAtBeginning(String title, String director, int year, int rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }   
    void addMovieAtPosition(int pos, String title, String director, int year, int rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (pos == 0) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        Movie curr = head;
        int i = 0;
        while (curr != null && i < pos - 1) {
            curr = curr.next;
            i++;
        }
        if (curr == null) {
            addMovie(title, director, year, rating);
            return;
        }
        newMovie.next = curr.next;
        newMovie.prev = curr;
        if (curr.next != null) {
            curr.next.prev = newMovie;
        } else {
            tail = newMovie;
        }
        curr.next = newMovie;
    }   
    void searchByDirector(String dir) {
        Movie curr = head;
        while (curr != null) {
            if (curr.director.equalsIgnoreCase(dir)) {
                System.out.println(curr.title + " " + curr.year + " " + curr.rating);
            }
            curr = curr.next;
        }
    }   
    void searchByRating(int r) {
        Movie curr = head;
        while (curr != null) {
            if (curr.rating == r) {
                System.out.println(curr.title + " " + curr.director + " " + curr.year);
            }
            curr = curr.next;
        }
    }   
    void displayByTitle(String title) {
        Movie curr = head;
        while (curr != null) {
            if (curr.title.equalsIgnoreCase(title)) {
                System.out.println(curr.director + " " + curr.year + " " + curr.rating);
                return;
            }
            curr = curr.next;
        }
    }   
    void displayForward() {
        Movie curr = head;
        while (curr != null) {
            System.out.println(curr.title + " " + curr.director + " " + curr.year + " " + curr.rating);
            curr = curr.next;
        }
    }  
    void displayReverse() {
        Movie curr = tail;
        while (curr != null) {
            System.out.println(curr.title + " " + curr.director + " " + curr.year + " " + curr.rating);
            curr = curr.prev;
        }
    }
}
public class MovieManagement {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addMovie("Inception", "Nolan", 2010, 9);
        list.addMovie("Interstellar", "Nolan", 2014, 9);
        list.addMovie("The Godfather", "Coppola", 1972, 9);
        
        System.out.println("Forward:");
        list.displayForward();
        
        System.out.println("\nReverse:");
        list.displayReverse();
        
        System.out.println("\nBy Director Nolan:");
        list.searchByDirector("Nolan");
        
        System.out.println("\nRating 9:");
        list.searchByRating(9);
        
        System.out.println("\nBy Title Inception:");
        list.displayByTitle("Inception");
    }
}
