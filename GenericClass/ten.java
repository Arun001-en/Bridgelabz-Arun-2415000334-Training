import java.util.Arrays;
import java.util.List;

class Product { double price; Product(double p){price=p;} double getPrice(){return price;} }
class Mobile extends Product { Mobile(double p){super(p);} }
class Laptop extends Product { Laptop(double p){super(p);} }

class Calculator {
    static double calculateTotal(List<? extends Product> list){
        double t=0;
        for(Product p:list) t+=p.getPrice();
        return t;
    }
    public static void main(String[] args){
        System.out.println(calculateTotal(Arrays.asList(new Mobile(10000),new Mobile(8000))));
        System.out.println(calculateTotal(Arrays.asList(new Laptop(50000),new Laptop(60000))));
    }
}
