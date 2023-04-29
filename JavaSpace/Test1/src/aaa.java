
public class aaa {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		
		int[] b = new int[5];
		
		System.arraycopy(a, 0, b, 0, a.length);
		
		b[4] = 10;
		
		for(int c : b) {
			System.out.println(c);
		}
	}
}
