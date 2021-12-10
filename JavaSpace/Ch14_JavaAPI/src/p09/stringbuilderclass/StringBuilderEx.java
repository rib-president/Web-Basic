package p09.stringbuilderclass;

public class StringBuilderEx {
	public static void main(String[] args) {
		String data = "ABC";
		
		System.out.println(System.identityHashCode(data));
		System.out.println(data);
		
		data = data + "DEF";
		System.out.println(System.identityHashCode(data));
		System.out.println(data);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Java ");
		sb.append("Program Study");
		System.out.println(sb);
		
		sb.insert(4,  "2");
		System.out.println(sb);
		
		sb.setCharAt(4, '6');
		System.out.println(sb);
		
		sb.replace(6, 13, "Book");
		System.out.println(sb);
		
		sb.delete(4, 5);
		System.out.println(sb);
		
		int length = sb.length();
		System.out.println("총 문자 수 : " + length);
		
		String result = sb.toString();
		System.out.println(result);
	}
}
