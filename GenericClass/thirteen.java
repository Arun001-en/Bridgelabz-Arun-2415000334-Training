class ProductCategory {}
class BookCategory extends ProductCategory {}
class ClothingCategory extends ProductCategory {}

class ProductX<T extends ProductCategory> {
    double price;
    T cat;
    ProductX(double p, T c){ price=p; cat=c; }
}

class Marketplace {
    static <T extends ProductX<?>> void applyDiscount(T p, double percent){
        p.price = p.price - (p.price*percent/100);
    }
}
