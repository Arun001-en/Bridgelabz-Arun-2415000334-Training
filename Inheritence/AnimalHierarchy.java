package Inheritance;

class Animal{//parent class OR super class
	String name;
	int age;
	void makeSound() {
		System.out.println("Animal make sound");
	}
	Animal(String name, int age){
		this.name = name ;
		this.age = age;
	}
}

//Child classes OR subclasses
class Dog extends Animal{
	Dog(String name, int age){
		super(name , age);
	}
	void makeSound() {
		System.out.println("barks!");
	}
}


class Cat extends Animal{
	Cat(String name , int age){
		super(name,age);
	}
	void makeSound() {
		System.out.println("meows");
	}
}

class Bird extends Animal{
	Bird(String name , int age){
		super(name, age);
	}
	void makeSound() {
		System.out.println("sings");
	}
}

public class AnimalHierarchy {

	public static void main(String[] args) {
		Dog dogObj = new Dog("jack",5);
		Cat catObj = new Cat("xyz",4);
		Bird birdObj = new Bird("abc",2);
		System.out.print(dogObj.name + " is a dog of age " + dogObj.age+" and sounds ");
		dogObj.makeSound();
		System.out.print(catObj.name + " is a cat of age " + catObj.age+" and sounds ");
		catObj.makeSound();
		System.out.print(birdObj.name + " is a bird of age " + birdObj.age+" and sounds ");
		birdObj.makeSound();
	}

}