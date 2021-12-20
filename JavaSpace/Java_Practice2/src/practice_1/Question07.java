package practice_1;

// 자연수 1부터 시작해서 모든 홀수와 3의 배수인 짝수를 더해 나간다. 
// 그 합이 언제(몇을 더했을 때) 1000을 넘어서는지 , 
// 그리고 1000을 넘어선 값은 얼마가 되는지 계산하여 출력하는 프로그램을 작성해 보자.
public class Question07 {
	public static void main(String[] args) {
		int count = 0;
		int sum = 0;
		int i = 1;
		
		while(sum < 1000) {
			if(i % 2 == 1) {
				count++;
				sum += i;
			} else if(i % 3 == 0) {
				count++;
				sum += i;
			}
			i++;
		}
		System.out.println(count + "번 더했을 때, " + sum + "으로 1000이 넘는다.");
	}
}
