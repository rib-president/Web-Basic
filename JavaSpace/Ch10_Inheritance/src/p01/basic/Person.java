package p01.basic;

public class Person {
	String name;
	int age;
	
	void speak() {
		System.out.println(name + "은 말합니다.");
	}
	
	void eat() {
		System.out.println(name + "은 먹습니다.");
	}
	
	void walk() {
		System.out.println(name + "은 걷습니다.");
	}
	
	void sleep() {
		System.out.println(name + "은 잠을 잡니다.");
	}
}
