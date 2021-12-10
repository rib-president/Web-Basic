package p06.hybrid_repeat;

//	while문 안에 for문이 있는 경우
public class HybridRepeatEx2 {
	public static void main(String[] args) {
		int i = 0;
		
		while (i<5) {
			//	for문 시작할 때 최초 한 번 실행되는 명령어 => int j=i;
			//	for문 반복할 때마다 for문 처음에 실행되는 명령어 j>1;
			//	for문 반복할 때마다 for문 마지막에 실행되는 명령어 j--
			for (int j=i;j>1;j--) {
				System.out.print(j + " ");
			}
			System.out.println("*****");
			i++;
		}
	}
}
