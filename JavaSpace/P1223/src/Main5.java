
public class Main5 {
	public static void main(String[] args) {
		// 쓰레드
		System.out.println("실행되는 코드1...");
		System.out.println("실행되는 코드2...");
		
		SomeCalc sc = new SomeCalc();
		sc.start();
		
		System.out.println("실행되는 코드3...");
		System.out.println("실행되는 코드4...");		
	}
}

//class SomeCalc {
//	public void test() {
//		for(int i=0;i<=10;i++) {
//			System.out.println(i);
//		}
//	}
//}

class SomeCalc extends Thread {
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println(i);
		}
	}
}