package practice_8.Question01_02;

// 2차원 배열을 시계 방향으로 90도, 180도, 270도 회전
public class Question02 {
	public static void main(String[] args) {
		int[][] array = {
				{1, 0, 0},
				{1, 1, 1},
				{1, 0, 1},
				{1, 0, 1}
		};
		System.out.println("출력\n");
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[0].length;j++) {
				System.out.print(array[i][j] + " ");				
			}
			System.out.println();
		}
		
		System.out.println("\n" + 90);
		for(int i=0;i<array[0].length;i++) {
			for(int j=array.length-1;j>=0;j--) {
				System.out.print(array[j][i] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n" + 180);
		for(int i=array.length-1;i>=0;i--) {
			for(int j=array[0].length-1;j>=0;j--) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n" + 270);
		for(int i=array[0].length-1;i>=0;i--) {
			for(int j=0;j<array.length;j++) {
				System.out.print(array[j][i] + " ");
			}
			System.out.println();
		}
	}
}
