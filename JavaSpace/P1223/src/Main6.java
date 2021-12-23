
public class Main6 {
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.start();
		
		Test2 t2 = new Test2();
		t2.start();
		
		for(int i=0;i<300;i++) {
			System.out.println("메인쓰레드 : " + i);
		}
	}
}

class Test1 extends Thread {
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.println("추가1쓰레드 : " + i);
		}
	}
}

class Test2 extends Thread {
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.println("추가2쓰레드 : " + i);
		}
	}
}