package p02.io.outputstream;

import java.io.*;

public class FileWrite2 {
	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("src/p02/io/outputstream/test2.txt");
		byte[] data = "ABCDE".getBytes();
		
		os.write(data, 1, 2);
		
		os.flush();
		os.close();
	}
}
