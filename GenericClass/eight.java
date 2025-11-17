import java.util.Arrays;
import java.util.List;

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
class PrintAnimals {
    static void printAnimals(List<? extends Animal> list) {
        for(Animal a:list) System.out.println(a);
    }
    public static void main(String[] args) {
        printAnimals(Arrays.asList(new Dog(),new Dog()));
        printAnimals(Arrays.asList(new Cat(),new Cat()));
    }
}