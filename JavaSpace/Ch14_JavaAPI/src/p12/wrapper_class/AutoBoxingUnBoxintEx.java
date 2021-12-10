package p12.wrapper_class;

public class AutoBoxingUnBoxintEx {
	public static void main(String[] args) {
		Integer obj1 = 100;
		System.out.println(obj1.intValue());
		
		int i1 = obj1;
		System.out.println(i1);
		
		int result1 = obj1 + 100;
		System.out.println(result1);
		
		Double obj2 = 100.23;
		System.out.println(obj2.doubleValue());
		
		double d1 = obj2;
		System.out.println(d1);
		
		double result2 = d1 + 12.3;
		System.out.println(result2);
	
	}
}
