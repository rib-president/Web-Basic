package p01.basic;

public class LambdaEx {
	public static void main(String[] args) {
		MyInterfaceImpl mi = new MyInterfaceImpl();
		mi.sayHello();
		
		MyInterface ma = new MyInterface() {

			@Override
			public void sayHello() {
				System.out.println("Hello MyInterface anonymous Instance");
			}		
		};
		ma.sayHello();
		
		MyInterface ml = ()->{System.out.println("Hello Lambda function");};
		ml.sayHello();

	}	
}
