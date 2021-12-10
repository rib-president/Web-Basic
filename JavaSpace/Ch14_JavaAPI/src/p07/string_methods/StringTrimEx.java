package p07.string_methods;

public class StringTrimEx {
	public static void main(String[] args) {
		String tel1 = "    02";
		String tel2 = "123    ";
		String tel3 = "    1234    ";
		
		String tel = tel1 + tel2 + tel3;
		System.out.println(tel);

		tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);
	}
}
