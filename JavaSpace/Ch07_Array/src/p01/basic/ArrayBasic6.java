package p01.basic;

//	합계, 산술평균값 구하기
public class ArrayBasic6 {
	public static void main(String[] args) {
		int[] scores = {95, 71, 84, 93, 87};
		
		int sum = 0;
		
		for(int score : scores) {
			sum += score;
		}

		double average = (double)sum / scores.length;
		System.out.println("전체 합계 = "  + sum);
		System.out.println("전체 평균 = "  + average);
	}
}
