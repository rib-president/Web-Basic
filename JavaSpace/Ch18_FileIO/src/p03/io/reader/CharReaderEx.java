package p03.io.reader;

import java.io.*;

public class CharReaderEx {
	public static void main(String[] args) {
		Reader r = null;
		
		try {
			r = new FileReader("src/p02/io/outputstream/test.txt");
			int readData;
			while(true) {
				readData = r.read();
				if(readData == -1) {
					break;
				}
				System.out.println((char)readData);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
