package p07.file_practice;

import java.io.*;

public class FileWriterEx {
	public static void main(String[] args) throws IOException {
		File file = new File("src/p07/file_practice/file.txt");
		FileWriter fw = new FileWriter(file, true);
		
		fw.write("FileWriter는 한글로 된 \r\n");
		fw.write("문자열을 바로 출력할 수 있다. \r\n");
		fw.flush();
		fw.close();
		System.out.println("파일에 저장되었습니다.");
	}
}
