package p04.io.writer;

import java.io.*;

public class CharWriterEx {
	public static void main(String[] args) throws IOException {
		Writer w = new FileWriter("src/p04/io/writer/test.txt");
		char[] c = "홍길동".toCharArray();
		
		for(int i=0;i<c.length;i++) {
			w.write(c[i]);
		}
		
		w.flush();
		w.close();
	}
}
