class Ticket {
    int id;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    Ticket next;
    Ticket(int id, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.id = id;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = this;
    }
}
class OnlineTicketReservation {
    private Ticket head;

    public OnlineTicketReservation() {
        head = null;
    }
    public void addTicket(int id, String customerName, String movieName, int seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(id, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            return;
        }
        Ticket current = head;
        do {
            current = current.next;
        } while (current.next != head);
        current.next = newTicket;
        newTicket.next = head;
    }
    public boolean removeTicketByID(int id) {
        if (head == null) return false;
        if (head.id == id) {
            if (head.next == head) {
                head = null;
                return true;
            }
            Ticket last = head;
            do {
                last = last.next;
            } while (last.next != head);
            last.next = head.next;
            head = head.next;
            return true;
        }
        Ticket current = head;
        do {
            if (current.next.id == id) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }
    public void searchByCustomerName(String customerName) {
        boolean found = false;
        Ticket current = head;
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        do {
            if (current.customerName.equalsIgnoreCase(customerName)) {
                displayTicket(current);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("Customer not found.");
        }
    }
    public void searchByMovieName(String movieName) {
        boolean found = false;
        Ticket current = head;
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        do {
            if (current.movieName.equalsIgnoreCase(movieName)) {
                displayTicket(current);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("Movie not found.");
        }
    }
    public int calculateTotalBookedTickets() {
        if (head == null) return 0;
        int count = 1;
        Ticket current = head.next;
        while (current != head) {
            count++;
            current = current.next;
        }
        return count;
    }
    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        Ticket current = head;
        do {
            displayTicket(current);
            current = current.next;
        } while (current != head);
    }
    private void displayTicket(Ticket ticket) {
        System.out.printf("ID: %d, Customer: %s, Movie: %s, Seat: %d, Time: %s\n",
            ticket.id, ticket.customerName, ticket.movieName, ticket.seatNumber, ticket.bookingTime);
    }
}
class Main {
    public static void main(String[] args) {
        OnlineTicketReservation system = new OnlineTicketReservation();
        
        system.addTicket(1, "Alice", "Avengers", 5, "2026-02-18 18:30");
        system.addTicket(2, "Bob", "Avengers", 10, "2026-02-18 18:35");
        system.addTicket(3, "Charlie", "SpiderMan", 3, "2026-02-18 19:00");
        system.addTicket(4, "Diana", "Avengers", 7, "2026-02-18 18:40");
        
        System.out.println("=== All Tickets ===");
        system.displayAllTickets();
        
        System.out.println("\nTotal booked tickets: " + system.calculateTotalBookedTickets());
        
        System.out.println("\n=== Search by Customer 'Alice' ===");
        system.searchByCustomerName("Alice");
        
        System.out.println("\n=== Search by Movie 'Avengers' ===");
        system.searchByMovieName("Avengers");
        
        System.out.println("\n=== Remove ticket ID 2 ===");
        system.removeTicketByID(2);
        system.displayAllTickets();
        
        System.out.println("Total booked tickets: " + system.calculateTotalBookedTickets());
    }
}
