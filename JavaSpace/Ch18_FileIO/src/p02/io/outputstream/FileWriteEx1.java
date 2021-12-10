package p02.io.outputstream;

import java.io.*;

public class FileWriteEx1 {
	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("src/p02/io/outputstream/test.txt");
		byte[] data = "ABC".getBytes();
		
		for(int i=0;i<data.length;i++) {
			os.write(data[i]);
		}
		
		os.flush();
		os.close();
	}
}
