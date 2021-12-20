
public class Main3 {
	public static void main(String[] args) {
		int[][] arr = new int[3][4];
		
		arr[0][0] = 10;
		
		arr[2][3] = 50;

		arr[1] = new int[5];
		
		arr[0] = null;
		arr[1] = null;
		arr[2] = null;
		arr = null;

	}
}
