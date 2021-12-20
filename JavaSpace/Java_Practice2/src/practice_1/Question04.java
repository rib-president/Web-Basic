package practice_1;

// 구구단을 출력해보자
// 구구단을 출력을 하되 7단과 6단을 제외하고 출력하자.
public class Question04 {
	public static void main(String[] args) {
		for(int i=2;i<=9;i++) {
			if(i == 7 || i == 6) continue;
			for(int j=1;j<=9;j++) {
				System.out.println(i + " x " + j + " = " + (i*j));
			}
			System.out.println();
		}
	}
}
