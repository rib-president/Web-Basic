package p01.practice;

//	1.2차원 배열 모든 원소의 합 구하기
//	2.2차원 배열 행별 원소의 합 구하기
public class SumAllTwoDimData {
	public static void main(String[] args) {
		int[][] numbers = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				{10, 11, 12}
		};
		
		int sum = 0;
		
		for(int i=0;i<numbers.length;i++) {
			for(int j=0;j<numbers[i].length;j++) {
				sum += numbers[i][j];
			}
		}
		
		System.out.println("2차원 배열 전체 원소의 합 = " + sum);

		//	각 행의 합 구하기
		for(int i=0;i<numbers.length;i++) {
			int rowSum = 0;
			for(int j=0;j<numbers[i].length;j++) {
				rowSum += numbers[i][j];
			}
			System.out.println((i+1) + "번째 행의 합 = " + rowSum);
		}

		//	각 열의 합 구하기
		
		for(int col=0;col<numbers[col].length;col++) {
			int colSum = 0;
			for(int row=0;row<numbers.length;row++) {
				colSum += numbers[row][col];
			}
			System.out.println((col+1) + "번째 열의 합 = " + colSum);
		}

		
		
	}
}
