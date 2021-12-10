package p06.hybrid_repeat;

//	for문과 while문 조합 예
public class HybridRepeatEx {
	public static void main(String[] args) {
		
		//	int = 0;은 for문 안에서 변수 선언된 것과 같아서, for문이 끝나면 i변수는
		//	메모리에서 사라짐
		for (int i=0;i<5;i++) {
			//	println => print + ln(line, enter key)
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i=5;i>0;i--) {
			//	println => print + ln(line, enter key)
			System.out.print(i + " ");
		}
		
		System.out.println();
		for (int i=1;i<5;i++) {
			int j = 0;
			while (j<i) {
				System.out.print(j + " ");
				j++;
			}
			System.out.println();
		}
	}
}
