package p02.datatypes.casting;

public class CastingEx {

	public static void main(String[] args) {
		char ch = 'A';
		int number = 88;
		
		System.out.println("ch = " + ch);
		System.out.println("number = " + number);
		
		// 자동형변환 불가(4bytes int type => 2bytes char type X)
		// ch = number;

		// casting(강제형변환)
		ch = (char)number;
		
		System.out.println("ch = " + ch);
	}

}
