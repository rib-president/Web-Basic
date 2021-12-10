package p01.if_basic;

public class IfBasic4 {
	public static void main(String[] args) {
		int i = 10;
		int j = 5;
		int k = 7;
		
		if(i > k) { 
			if (j > k) {
				System.out.println("i와 j는 k보다 큽니다.");
				//	if ~ else 문 사용 가능
			} else {
				System.out.println("k는 i보다 작지만, j보다 큽니다.");
			}
		} else {
			System.out.println("i는 k보다 작거나 같습니다.");
		}
	}
}
