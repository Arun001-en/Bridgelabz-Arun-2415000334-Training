import java.util.ArrayList;

class Cart<T> {
    ArrayList<T> items=new ArrayList<>();
    void addItem(T i){ items.add(i); }
    void removeItem(T i){ items.remove(i); }
    void displayItems(){ System.out.println(items); }
    public static void main(String[] args) {
        Cart<String> e=new Cart<>();
        e.addItem("Laptop");
        e.displayItems();

        Cart<String> c=new Cart<>();
        c.addItem("Shirt");
        c.displayItems();
    }
}
