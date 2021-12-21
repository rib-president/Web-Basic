package a.a.a;

public class Main1 {
	public static void main(String[] args) {
		Student st1 = new Student();
		
		st1.age = 10;
		st1.name = "한조";
		st1.score = 77;
		
		Student st2 = new Student(1, 3, "트레이서");
		
		st1.printData();
		st1.printData();
		st1.printData();
		st1.printData();
		st2.printData();
		
		int result1 = st2.plus(13, 6);
		int result2 = st1.plus(13, 6);
		
		Math.abs(0.123);
		// Math.abs("안녕하세요");
		// Math.abs(1231, 1313);
		
		double xxx = Math.cos(12938123);
		
	}
}

class Student {
	// 필드
	int age;
	int score;
	String name;
	
	// 생성자(new로 인스턴스가 생성될 때 최초 1번 실행)
	Student() {
		// 실행되는 코드 위치
		System.out.println("야호...!!");
	}
	
	// 생성자 오버로딩
	Student(int age, int score, String name) {
		this.age = age;
		this.score = score;
		this.name = name;
		
		System.out.println("야호2...!!");
	}
	
	// 메소드
	void printData() {
		System.out.println(this.name);
		System.out.println(this.age);
		System.out.println(this.score);
	}
	
	int plus(int a, int b) {
		int result = a + b + score;
		return result;
		//System.out.println("두 개의 합은 " + result + "입니다.");
	}
	
	// 오버로딩
	int plus(double a, double b) {
		return 1111;
		//System.out.println("두 개의 합은 " + result + "입니다.");
	}

	
}

class Car {
	int currentSpeed;
	String color;
	int fuel;
}