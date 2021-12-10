package p06.FileManage;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileManagementEx {
	public static void main(String[] args) throws URISyntaxException, IOException {
		File dir = new File("src/p06/FileManage/dir");
		File file1 = new File("src/p06/FileManage/dir/file1.txt");
		File file2 = new File("src/p06/FileManage/dir/file2.txt");
		File file3 = new File(new URI("file:///c:/DevSpace/JavaSpace/Ch18_FileIO/src/p06/FileManage/dir/file3.txt"));

		if(!dir.exists()) {
			dir.mkdirs();
		}
		if(!file1.exists()) {
			file1.createNewFile();
		}
		if(!file2.exists()) {
			file2.createNewFile();
		}
		if(!file3.exists()) {
			file3.createNewFile();
		}
		
		File tmp = new File("src/p06/FileManage");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd	a	HH:mm");
		File[] contents = tmp.listFiles();
		
		System.out.println("날짜	시간	형태	크기	이름");
		System.out.println("-----------------------------");
		for (File file : contents) {
			System.out.println(sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.println("\t<DIR>\t\t " + file.length() + "\t"
						+ file.getName());
			} else {
				System.out.println("\t\t\t " + file.length() + "\t"
						+ file.getName());	
			}
			System.out.println();
		}
	}
}
