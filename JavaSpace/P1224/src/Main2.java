import java.net.*;

public class Main2 {
	public static void main(String[] args) throws Exception {
		System.out.println("프로그램 시작...");
		try {
			Socket s = new Socket("111.111.111.11", 11111);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		new TestController().testA(10);
		
		System.out.println("프로그램 종료...");
	}
}

class TestController {
	void testA(int v) throws Exception {
		testB(v);
	}
	
	void testB(int v) throws Exception {

		testC(v);

	}
	
	void testC(int v) throws Exception {
		if(v == 0) {
			throw new Exception("v가 0이면 절대 안됨");
		}
		System.out.println("야호-" + v);
	}
}