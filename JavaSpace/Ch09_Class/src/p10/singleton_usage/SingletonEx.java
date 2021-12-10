package p10.singleton_usage;

public class SingletonEx {
	public static void main(String[] args) {
		// Singleton class의 생성자를 private으로 했기 때문에 new로 인스턴스
		//	생성 불가
		//Singleton s1 = new Singleton();
		// singleton field가 private으로 선언되어 있어서 static으로 
		// 선언되어있어도 다른 class에서 접근 불가
		//Singleton.singleton;
		
		// Singleton class의 생성자를 private으로 선언했기 때문에, 다른 class에서
		// 사용할 때는 new로 객체 생성 불가
		// => 유일하게 사용할 수 있는 방법은 Singleton class이름으로, static field나
		// static method 호출하는 것
		// => singleton field를 private으로 선언하여 static method 호출만 가능
		
		Singleton singleton = Singleton.getInstance();
		singleton.printHello();
		
		Singleton singleton2 = Singleton.getInstance();
		
		System.out.println(System.identityHashCode(singleton));
		System.out.println(System.identityHashCode(singleton2));
		
		if(singleton == singleton2) {
			System.out.println("같은 싱글톤 인스턴스입니다.");
		} else {
			System.out.println("다른 싱글톤 인스턴스입니다.");
		}
	}
}