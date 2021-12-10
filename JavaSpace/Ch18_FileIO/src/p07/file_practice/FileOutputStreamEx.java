package p07.file_practice;

import java.io.*;

public class FileOutputStreamEx {
	public static void main(String[] args) throws IOException {
		String originalFileName = "c:/desertfox.jpg";
		String targetFileName = "src/p07/file_practice/copied_desertfox.jpg";
		
		FileInputStream fis = new FileInputStream(originalFileName);
		FileOutputStream fos = new FileOutputStream(targetFileName);
		
		int readByteNo;
		byte[] readBytes = new byte[100];
		while((readByteNo = fis.read(readBytes)) != -1) {
			fos.write(readBytes, 0, readByteNo);
		}

		fis.close();
		fos.flush();
		fos.close();
		
		System.out.println("복사가 잘 되었습니다.");
	}
}
