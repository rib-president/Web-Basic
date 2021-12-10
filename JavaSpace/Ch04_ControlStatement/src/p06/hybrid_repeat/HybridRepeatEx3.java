package p06.hybrid_repeat;

//	while문 안에 for문이 있는 두 번째 예제
public class HybridRepeatEx3 {
	public static void main(String[] args) {
		int i = 5;
		while (i>=1) {
			int num = 1;
			for (int j=1;j<=i;j++) {
				System.out.print(num + "xxx");
				num *= 2;
			}
			
			System.out.println();
			i--;
		}
	}
}
