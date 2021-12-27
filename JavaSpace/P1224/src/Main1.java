
public class Main1 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		
		// 이 경우엔 논리적 예외처리가 좋음
		if(b != 0) {
			int result = a / b;
			System.out.println(result);
		} else {
			System.out.println("b의 값이 이상합니다.");
		}
		
		try {
			int result = a / b;
			System.out.println(result);
		} catch(Exception e) {
			System.out.println("뭔가 문제가 있음!");
		}
		
		System.out.println("프로그램 종료");
	}
}
