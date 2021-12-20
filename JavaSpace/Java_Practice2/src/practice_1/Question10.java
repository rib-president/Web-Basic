package practice_1;

// 863은 소수 인가? 2~100사이의 소수를 구해보자
public class Question10 {
	public static void main(String[] args) {
		String result = "소수 입니다.";
		for(int i=2;i<=(863/2);i++) {
			if(863 % i == 0) {
				result = "소수가 아닙니다.";
				break;
			}
		}
		
		System.out.println("863은 " + result);
		
		
		for(int i=2;i<=100;i++) {
			int count = 1;
			for(int j=2;j<=(i/2);j++) {
				if(i % j == 0)
					count++;
			}
			if(count == 1) {
				System.out.print(i + " ");
			}
		}
	}
}
