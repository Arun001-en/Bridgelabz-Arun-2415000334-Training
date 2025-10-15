// Prototype object class
public class Last implements Cloneable {
    String name;
    int id;

    public Last(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Override clone() to enable cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }
}

// Usage
public class Last {
    public static void main(String[] args) {
        try {
            Model prototype = new Model("Prototype1", 101);
            Model clone = (Model) prototype.clone();

            System.out.println(prototype.name + " " + prototype.id);
            System.out.println(clone.name + " " + clone.id); 
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
