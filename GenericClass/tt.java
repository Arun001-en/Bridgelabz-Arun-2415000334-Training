import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {}
class Electronics extends WarehouseItem {}
class Groceries extends WarehouseItem {}
class Furniture extends WarehouseItem {}

class Storage<T extends WarehouseItem> {
    ArrayList<T> items=new ArrayList<>();
    void add(T i){ items.add(i); }
}
class DisplayWarehouse {
    static void display(List<? extends WarehouseItem> list){
        for(WarehouseItem w:list) System.out.println(w);
    }
}
