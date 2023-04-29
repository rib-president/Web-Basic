class Solution {
    public static int[][] solution(int[][] matrix, int r) {
        int[][] answer = {};
        
        int length = matrix[0].length;
        answer = new int[length][length];
        
        switch(r % 4) {
            case 0:
                answer = matrix;
                break;
            case 1:
                for(int i=0;i<length;i++) {
                    for(int j=0;j<length;j++) {
                        answer[j][length-i-1] = matrix[i][j];
                    }
                }
                break;
            case 2:
                for(int i=0;i<length;i++) {
                    for(int j=0;j<length;j++) {
                        answer[length-1-i][length-1-j] = matrix[i][j];
                    }
                }
                break;
            case 3:
                for(int i=0;i<length;i++) {
                    for(int j=0;j<length;j++) {
                        answer[length-1-j][i] = matrix[i][j];
                    }
                }
                break;
        }


        return answer;
    }


    public static void main(String[] args) {
		int[][] matrix = {{1, 2}, {3, 4}};
		int r = 8;
		int[][] answer = solution(matrix, r);
		
		for(int i=0;i<answer[0].length;i++) {
			for(int j=0;j<answer[0].length;j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}
}