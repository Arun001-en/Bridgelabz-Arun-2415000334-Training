class Fruit {}
class Apple extends Fruit {}
class Mango extends Fruit {}
class Car {}   // Not fruit

class FruitBox<T extends Fruit> {
    ArrayList<T> list = new ArrayList<>();

    public void add(T fruit) {
        list.add(fruit);
    }

    public void display() {
        for (T f : list) System.out.println(f.getClass().getSimpleName());
    }
}

class TestFruit {
    public static void main(String[] args) {
        FruitBox<Fruit> fb = new FruitBox<>();

        fb.add(new Apple());
        fb.add(new Mango());

        // fb.add(new Car()); ❌ ERROR – Car is not Fruit

        fb.display();
    }
}
