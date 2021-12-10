package p07.break_continue;

//	continue를 이용하여 1~10까지 짝수의 합을 구하는 예
//	continue 사용 예
//	1.for, while, do~while loop에서 사용됨
//	2.반복문안에 continue 다음에 나타나는 명령어들은 실행하지 않고, 다음 loop 시작으로
//		돌아가서 실행
//	
public class ContinueEx {
	public static void main(String[] args) {
		int sum = 0;
		
		for (int i=1;i<=10;i++) {
			//	i % 2 != 0 => i가 홀수인 경우
			if (i % 2 != 0) {
				continue;
			}
			System.out.println("짝수 숫자 = " + i);
			sum += i;
		}
		System.out.println("1~10사이의 짝수의 합 = " + sum);
	}
}
