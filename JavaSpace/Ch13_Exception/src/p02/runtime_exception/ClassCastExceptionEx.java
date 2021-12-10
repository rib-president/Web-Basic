package p02.runtime_exception;

class Animal { }
class Dog extends Animal { }
class Cat extends Animal { }

public class ClassCastExceptionEx {
	public static void main(String[] args) {
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat);
	}
	
	public static void changeDog(Animal animal) {
//		if(animal instanceof Dog) {
//			Dog dog = (Dog)animal;
//		}
		Dog dog = (Dog)animal;
	}
}
