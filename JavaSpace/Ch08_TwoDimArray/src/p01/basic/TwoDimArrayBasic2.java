package p01.basic;

//	2차원 배열(2 dimensional Array) 선언 후 사용
//	- new int[row_num][col_num] 예 : new int[4][3]; => 4행 3열
public class TwoDimArrayBasic2 {
	public static void main(String[] args) {
		int[][] numbers = new int[4][3];
		
		numbers[0][0] = 1;
		numbers[0][1] = 2;
		numbers[0][2] = 3;

		numbers[1][0] = 4;
		numbers[1][1] = 5;
		numbers[1][2] = 6;

		numbers[2][0] = 7;
		numbers[2][1] = 8;
		numbers[2][2] = 9;

		numbers[3][0] = 10;
		numbers[3][1] = 11;
		numbers[3][2] = 12;

		//	행의 길이(갯수를 구하는 방법)
		System.out.println("행의 길이 = " + numbers.length);
		
		//	컬럼의 길이(갯수를 구하는 방법)
		System.out.println("첫 번째 행의 길이 = " + numbers[0].length);
		System.out.println("두 번째 행의 길이 = " + numbers[1].length);
		System.out.println("세 번째 행의 길이 = " + numbers[2].length);
		
		//	2차원 배열을 중첩 for문을 사용하여 2차원 배열 원소를 읽는 방법
		for(int i=0;i<numbers.length;i++) {
			for(int j=0;j<numbers[i].length;j++) {
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
