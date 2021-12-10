package p01.basic;

public class MyInterface2Impl {
	public static void main(String[] args) {
		MyInterface2 ma = new MyInterface2() {

			@Override
			public void calculator(int x, int y) {
				System.out.println("익명객체 결과 : " + (x*y));
			}
			
		};
		ma.calculator(20, 30);
		
		MyInterface2 ml = (x, y) -> {System.out.println("람다식 결과 : " + (x*y));};
		ml.calculator(5, 8);
		
		char a = 'a';
		char b = 'b';
		int str = a+b;
		
		System.out.println(str);
	}
}
