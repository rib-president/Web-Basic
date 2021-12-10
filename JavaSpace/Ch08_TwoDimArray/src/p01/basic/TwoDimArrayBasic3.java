package p01.basic;

//	2차원 배열 각 행의 원소 개수가 동일하지 않은 경우
public class TwoDimArrayBasic3 {
	public static void main(String[] args) {
		int[][] triangleArray = {
				{1, 2, 3, 4, 5},
				{2, 3, 4, 5},
				{3, 4, 5},
				{4, 5},
				{5}
		};
		
		for(int i=0;i<triangleArray.length;i++) {
			System.out.println((i+1) + "번째 행의 원소 개수 = " + 
					triangleArray[i].length);
		}
		
		for(int i=0;i<triangleArray.length;i++) {
			for(int j=0;j<triangleArray[i].length;j++) {
				System.out.print(triangleArray[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
