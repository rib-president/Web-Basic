package p05.system_class;

public class SystemTimeEx {
	public static void main(String[] args) {
		//long startTime = System.nanoTime();
		long startTime = System.currentTimeMillis();
		
		int sum = 0;
		for(int i=0;i<=1000000;i++) {
			sum += i;
		}
		
		//long endTime = System.nanoTime();
		long endTime = System.currentTimeMillis();
		
		System.out.println("sum = " + sum);
//		System.out.println("합계 소요 시간(nano seconds) = " + 
//				(endTime-startTime));
		System.out.println("합계 소요 시간(milli seconds) = " + 
				(endTime-startTime));		
	}
}
