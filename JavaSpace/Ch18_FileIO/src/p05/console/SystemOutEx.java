package p05.console;

import java.io.*;

public class SystemOutEx {
	public static void main(String[] args) throws IOException {
		OutputStream os = System.out;
		
		for(byte b = 48;b<58;b++) {
			os.write(b);
		}
		os.write(10);
		
		for(byte b=97;b<123;b++) {
			os.write(b);
		}
		os.write(10);
		
		String hangul = "가나다라마바사아자차카타파하";
		byte[] hangulBytes = hangul.getBytes();
		os.write(hangulBytes);
		
	}
}
