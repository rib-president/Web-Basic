package p12.wrapper_class;

public class ValueCompareEx {
	public static void main(String[] args) {
		Integer obj1 = 300;
		Integer obj2 = 300;
		
		System.out.println("obj1 == obj2의 결과 : " + (obj1 == obj2));
		System.out.println("unboxing 후 == 결과 : " + (obj1.intValue() == obj2.intValue()));
		System.out.println("equals() 결과 : " + obj1.equals(obj2));
	}
}
