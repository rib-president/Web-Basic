package p01.io.inputstream;

import java.io.*;


public class ReadEx1 {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("/C:/DevSpace/JavaSpace/Ch18_FileIO/src/p01/io/inputstream/test.txt");
//		InputStream is = new FileInputStream("src/p01/io/inputstream/test.txt");

		int readByte;
		
		while(true) {
			readByte = is.read();
			if(readByte == -1) {
				break;
			}
			System.out.println("readbyte : " + (char) readByte);
		}
		
	}
}
