abstract class Product {
    private int productId;
    private String name;
    private double price;
    public int getProductId(){ return productId; }
    public void setProductId(int id){ this.productId = id; }
    public String getName(){ return name; }
    public void setName(String n){ this.name = n; }
    public double getPrice(){ return price; }
    public void setPrice(double p){ this.price = p; }
    public abstract double calculateDiscount();
}
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
class Electronics extends Product implements Taxable {
    private double discountRate;
    public void setDiscountRate(double r){ this.discountRate = r; }
    @Override
    public double calculateDiscount(){ return getPrice() * discountRate / 100; }
    @Override
    public double calculateTax(){ return getPrice() * 18 / 100; }
    @Override
    public String getTaxDetails(){ return "GST 18%"; }
}
class Clothing extends Product implements Taxable {
    @Override
    public double calculateDiscount(){ return getPrice() * 10 / 100; }
    @Override
    public double calculateTax(){ return getPrice() * 5 / 100; }
    @Override
    public String getTaxDetails(){ return "GST 5%"; }
}
class Groceries extends Product {
    @Override
    public double calculateDiscount(){ return 0; }
}
public class ECommerce {
    public static void printFinalPrice(Product p){
        double price = p.getPrice();
        double discount = p.calculateDiscount();
        double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
        System.out.println(p.getName()+" Final: "+(price + tax - discount));
    }
    public static void main(String[] args){
        Electronics e = new Electronics(); e.setProductId(1); e.setName("Phone"); e.setPrice(20000); e.setDiscountRate(5);
        Clothing c = new Clothing(); c.setProductId(2); c.setName("Shirt"); c.setPrice(1000);
        Groceries g = new Groceries(); g.setProductId(3); g.setName("Rice"); g.setPrice(80);
        Product[] arr = {e,c,g};
        for(Product p: arr) printFinalPrice(p);
    }
}
