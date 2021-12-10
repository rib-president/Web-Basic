package p01.basic;

//	문자열을 int, 문자열을 double로 변환하는 방법
//	1.문자열을 int로 변환 : parseInt(변환할 문자열)
//	
public class StringBasic10 {
	public static void main(String[] args) {
		String intStr = "20";
		
		int intValue = Integer.parseInt(intStr);
		System.out.println(intValue * 5 + 4);

		String doubleStr = "5.2";
		
		double doubleValue = Double.parseDouble(doubleStr);
		System.out.println(doubleValue * 5 + 4);
	}
}
