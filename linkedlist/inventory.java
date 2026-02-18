
class Item {
    int id;
    String name;
    double price;
    int quantity;
    Item next;

    Item(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.next = null;
    }
}

class InventoryNode {
    Item head;

    public InventoryNode() {
        head = null;
    }

    public void addItemAtBeginning(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtPosition(Item newItem, int position) {
        if (position <= 1 || head == null) {
            addItemAtBeginning(newItem);
            return;
        }
        Item current = head;
        int count = 1;
        while (current.next != null && count < position - 1) {
            current = current.next;
            count++;
        }
        newItem.next = current.next;
        current.next = newItem;
    }

    public boolean updateQuantityByID(int id, int newQuantity) {
        Item current = head;
        while (current != null) {
            if (current.id == id) {
                current.quantity = newQuantity;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean updateQuantityByName(String name, int newQuantity) {
        Item current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                current.quantity = newQuantity;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public double calculateTotalInventoryValue() {
        double total = 0.0;
        Item current = head;
        while (current != null) {
            total += current.price * current.quantity;
            current = current.next;
        }
        return total;
    }

    public void displayTotalValue() {
        System.out.printf("Total Inventory Value: $%.2f\n", calculateTotalInventoryValue());
    }

    public void sortByNameAscending() {
        if (head == null) return;
        Item sorted = null;
        Item current = head;
        while (current != null) {
            Item next = current.next;
            sortedInsert(sorted, current);
            current = next;
        }
        head = sorted;
    }

    public void sortByNameDescending() {
        if (head == null) return;
        Item sorted = null;
        Item current = head;
        while (current != null) {
            Item next = current.next;
            sortedInsertDescending(sorted, current);
            current = next;
        }
        head = sorted;
    }

    private void sortedInsert(Item sorted, Item newItem) {
        if (sorted == null || newItem.name.compareToIgnoreCase(sorted.name) < 0) {
            newItem.next = sorted;
            sorted = newItem;
        } else {
            Item current = sorted;
            while (current.next != null && newItem.name.compareToIgnoreCase(current.next.name) >= 0) {
                current = current.next;
            }
            newItem.next = current.next;
            current.next = newItem;
        }
        head = sorted;
    }

    private void sortedInsertDescending(Item sorted, Item newItem) {
        if (sorted == null || newItem.name.compareToIgnoreCase(sorted.name) > 0) {
            newItem.next = sorted;
            sorted = newItem;
        } else {
            Item current = sorted;
            while (current.next != null && newItem.name.compareToIgnoreCase(current.next.name) <= 0) {
                current = current.next;
            }
            newItem.next = current.next;
            current.next = newItem;
        }
        head = sorted;
    }

    public void displayInventory() {
        Item current = head;
        while (current != null) {
            System.out.printf("ID: %d, Name: %s, Price: %.2f, Quantity: %d\n", 
                current.id, current.name, current.price, current.quantity);
            current = current.next;
        }
    }
}

class inventory {
    public static void main(String[] args) {
        InventoryNode inventory = new InventoryNode();
        
        inventory.addItemAtBeginning(new Item(1, "Laptop", 999.99, 10));
        inventory.addItemAtBeginning(new Item(2, "Mouse", 25.50, 50));
        inventory.addItemAtPosition(new Item(3, "Keyboard", 75.00, 30), 2);
        
        System.out.println("Original Inventory:");
        inventory.displayInventory();
        
        inventory.updateQuantityByID(1, 15);
        inventory.updateQuantityByName("Mouse", 60);
        
        System.out.println("\nAfter Updates:");
        inventory.displayInventory();
        
        inventory.displayTotalValue();
        
        System.out.println("\nSorted by Name (Ascending):");
        inventory.sortByNameAscending();
        inventory.displayInventory();
        
        System.out.println("\nSorted by Name (Descending):");
        inventory.sortByNameDescending();
        inventory.displayInventory();
    }
}
