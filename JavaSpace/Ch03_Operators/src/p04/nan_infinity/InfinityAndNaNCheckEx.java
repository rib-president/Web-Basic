package p04.nan_infinity;

public class InfinityAndNaNCheckEx {
	public static void main(String[] args) {
		int x = 5;
		double y = 0.0;
		double z;
		
		if ( y != 0.0 ) {

			z = x / y;
			
		} else {
			System.out.println("y가 0이어서 나누기 연산할 수 없습니다.");
		}
		
		z = x/y;
		
		System.out.println("z = " + z);
		
		if ((Double.isInfinite(z)) || (Double.isNaN(z))) {
			System.out.println("z의 값을 산출할 수 없습니다.");
		} else {
			z = z + 2;
		}
		

		System.out.println("z = " + z);

	}
}
