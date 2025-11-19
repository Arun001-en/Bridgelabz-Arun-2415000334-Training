import java.util.*;

public class Library {
    public static void main(String[] args) {
        Map<String, String> books = new TreeMap<>();

        books.put("978-1111111111", "Java");
        books.put("978-2222222222", "Python");
        books.put("978-3333333333", "C++");

        // search
        String isbn = "978-1111111111";
        System.out.println(books.getOrDefault(isbn, "Book not found"));

        // remove
        books.remove("978-3333333333");

        // print sorted
        for (String k : books.keySet())
            System.out.println(k + " -> " + books.get(k));

        // search by title
        String title = "Java";
        for (String k : books.keySet()) {
            if (books.get(k).equals(title))
                System.out.println("Found ISBN: " + k);
        }
    }
}
