package practice_4.Question08.Q1617;

//	객체 생성하여 instance메소드 호출 vs 클래스명으로 static메소드 호출
public class Printer {
	void println(int param) {
		System.out.println(param);
	}
	void println(boolean param) {
		System.out.println(param);
	}
	void println(double param) {
		System.out.println(param);
	}
	void println(String param) {
		System.out.println(param);
	}
	static void println2(int param) {
		System.out.println(param);
	}
	static void println2(boolean param) {
		System.out.println(param);
	}
	static void println2(double param) {
		System.out.println(param);
	}
	static void println2(String param) {
		System.out.println(param);
	}	
}
