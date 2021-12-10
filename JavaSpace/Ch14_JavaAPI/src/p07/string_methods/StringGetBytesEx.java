package p07.string_methods;

import java.io.UnsupportedEncodingException;

public class StringGetBytesEx {
	public static void main(String[] args) {
		String str = "안녕하세요";
		
		byte[] b1 = str.getBytes();
		System.out.println("b1 length = " + b1.length);
		String s1 = new String(b1);
		System.out.println(s1);
		
		try {
			byte[] b2 = str.getBytes("EUC-KR");
			System.out.println("b2 length = " + b2.length);
			String s2 = new String(b2, "EUC-KR");
			System.out.println(s2);
			
			byte[] b3 = str.getBytes("UTF-8");
			System.out.println("b3 length = " + b3.length);
			String s3 = new String(b3, "UTF-8");
			System.out.println(s3);

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

	}
}
