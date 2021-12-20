package practice_1;

// 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하시오.

public class Question09 {
	public static void main(String[] args) {
		int sum = 0;
		
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=i;j++) {
				sum += j;
			}
		}
		System.out.println(sum);
	}
}
