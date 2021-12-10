package p01.io.inputstream;

import java.io.*;

public class ReadEx2 {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("src/p01/io/inputstream/test.txt");
		int readByteNo;
		byte[] readByte = new byte[3];
		String data = "";
		
//		while(true) {
//			readByteNo = is.read(readByte);
//			if(readByteNo == -1) {
//				break;
//			}
//			data += new String(readByte, 0, readByteNo);
//		}
		
		
		while((readByteNo = is.read(readByte)) != -1) {
			data += new String(readByte, 0, readByteNo);
		}

		
		System.out.println("readbyte : " + data);
		
		is.close();
	}
}
