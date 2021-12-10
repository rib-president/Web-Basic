package p03.generic_method;

public class GenericMethodEx {
	public static void main(String[] args) {
		Box<Integer> b1 = Util.<Integer>boxing(100);
		//Box<Integer> b1 = Util.boxing(100);
		int i1 = b1.get();
		
		Box<String> s1 = Util.<String>boxing("홍길동");
		String name = s1.get();
	}
}
