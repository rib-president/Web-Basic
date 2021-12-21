
public class Main2 {
	public static void main(String[] args) {
		int sum = 0;
		
		for(int i=1;i<=76;i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
		System.out.println("안녕하세요");
		
		//문제 100의 루트 값을 구해보자(단, API 사용하지 않음)
		for(int i=1;i<=1000;i++) {
			if(i*i == 100) {
				System.out.println(i);
			}
		}
		
		Math.sqrt(100);
		Math.sin(10);
	}
}
