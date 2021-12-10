package p01.if_basic;

public class IfBasic2 {
	public static void main(String[] args) {
		int i = 10;
		
		if (i>0) { 
			System.out.println("i는 양수입니다.");
		}

		// if 안에 1개의 실행문만 있을 경우 실행문의 중괄호{}는 생략 가능(비추)
		if (i>0) 
			System.out.println("i가 역시 양수입니다.");

		if (i % 5 == 0) {
			System.out.println("i는 5의 배수입니다.");
		}
		
		if (i % 2 == 0) {
			System.out.println("i는 2의 배수입니다.");
		}
		
		if ((i % 5 == 0) || (i % 2 == 0)) {
			System.out.println("i는 5의 배수이거나 2의 배수입니다.");
		}

		if ((i % 5 == 0) && (i % 2 == 0)) {
			System.out.println("i는 5의 배수이면서 2의 배수입니다."
					+ "=> 10의 배수입니다.");
		}		
		
	}
}
