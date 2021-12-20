
public class Main1 {

	public static void main(String[] args) {
		//System.out.println("안녕하세요");
		
		// (1) a라는 이름을 가진 메모리를 생성하겠다 (2)메모리에 10이라는 값을 write
		{
			int a = 10;		
			int b = 20;
		}
		
		int a = 30;	// 이미 메모리에 올라간 같은 이름의 변수를 선언X
		
		String str1 = "안녕하세요";
		String str2 = "안녕하세요";

		System.out.println(str1);
		System.out.println(str2);
		
		if(str1==str2) {
			System.out.println("같다");
		}else {
			System.out.println("다르다.");
		}

	
		String str3 = new String("안녕하세요");
		String str4 = new String("안녕하세요");

		System.out.println(str3);
		System.out.println(str4);
		
		if(str3==str4) {
			System.out.println("같다");
		}else {
			System.out.println("다르다.");
		}
		
		if(str3.equals(str4)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다.");
		}
	}
}
