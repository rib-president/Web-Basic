package p04.generic_extends;

public class Util {
	public static <T extends Number> int compare(T t1, T t2) {
		double d1 = t1.doubleValue();
		double d2 = t2.doubleValue();
		
		return Double.compare(d1,  d2);
	}
}
