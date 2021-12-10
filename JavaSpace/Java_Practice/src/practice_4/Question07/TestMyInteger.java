package practice_4.Question07;

//	value가 7, 26인 인스턴스를 생성하여, getValue(), isEven(), isOdd(),
//	equals method 실행
public class TestMyInteger {
	public static void main(String[] args) {
		MyInteger obj1 = new MyInteger(7);
		MyInteger obj2 = new MyInteger(26);
		
		int equalTestNum = 7;
		System.out.println("------------------------------------------------");
		System.out.println("값: " + obj1.getValue() + ", 짝수? " + obj1.isEven()
		 + ", 홀수? " + obj1.isOdd() + ", " + equalTestNum + "과 동일한가? " + obj1.equals(equalTestNum));
		System.out.println("------------------------------------------------");
		System.out.println("값: " + obj2.getValue() + ", 짝수? " + obj2.isEven()
		 + ", 홀수? " + obj2.isOdd() + ", " + equalTestNum + "과 동일한가? " + obj2.equals(equalTestNum));
		System.out.println("------------------------------------------------");		
	}
}
