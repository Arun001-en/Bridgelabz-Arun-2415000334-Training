abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    public String getItemName(){ return itemName; }
    public void setItemName(String n){ this.itemName = n; }
    public double getPrice(){ return price; }
    public void setPrice(double p){ this.price = p; }
    public int getQuantity(){ return quantity; }
    public void setQuantity(int q){ this.quantity = q; }
    public String getItemDetails(){ return itemName+" "+quantity+" @ "+price; }
    public abstract double calculateTotalPrice();
}
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}
class VegItem extends FoodItem implements Discountable {
    @Override
    public double calculateTotalPrice(){ return getPrice()*getQuantity(); }
    @Override
    public double applyDiscount(){ return calculateTotalPrice()*0.05; }
    @Override
    public String getDiscountDetails(){ return "Veg 5%"; }
}
class NonVegItem extends FoodItem implements Discountable {
    @Override
    public double calculateTotalPrice(){ return getPrice()*getQuantity() + 30; }
    @Override
    public double applyDiscount(){ return calculateTotalPrice()*0.02; }
    @Override
    public String getDiscountDetails(){ return "NonVeg 2%"; }
}
public class FoodMain {
    public static void main(String[] args){
        FoodItem[] order = new FoodItem[2];
        VegItem v = new VegItem(); v.setItemName("Paneer"); v.setPrice(150); v.setQuantity(2);
        NonVegItem n = new NonVegItem(); n.setItemName("Chicken"); n.setPrice(200); n.setQuantity(1);
        order[0]=v; order[1]=n;
        for(FoodItem f: order){
            double total = f.calculateTotalPrice();
            double disc = (f instanceof Discountable) ? ((Discountable)f).applyDiscount() : 0;
            System.out.println(f.getItemDetails()+" Total: "+(total-disc));
        }
    }
}
