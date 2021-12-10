package p10.singleton_usage;

public class Singleton {
	private static Singleton singleton = new Singleton();

	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public void printHello() {
		System.out.println(System.identityHashCode(singleton));
		System.out.println("Hello, instance method");
	}
}
