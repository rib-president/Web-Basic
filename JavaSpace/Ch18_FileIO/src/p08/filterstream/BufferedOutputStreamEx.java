package p08.filterstream;

import java.io.*;

public class BufferedOutputStreamEx {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		int data = -1;
		long start = 0;
		long end = 0;
		
		fis = new FileInputStream("c:/desertfox.jpg");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("src/p08/filterstream/copied_desertfox.jpg");
		
		start = System.currentTimeMillis();
		while((data = bis.read()) != -1) {
			fos.write(data);
		}
		fos.flush();
		end = System.currentTimeMillis();
		fos.close();
		bis.close();
		fis.close();
		System.out.println("BufferedOutput 사용하지 않았을 때 : " + (end-start) + "ms");

	
		fis = new FileInputStream("c:/desertfox.jpg");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("src/p08/filterstream/copied_desertfox.jpg");
		bos = new BufferedOutputStream(fos);
		
		start = System.currentTimeMillis();
		while((data = bis.read()) != -1) {
			bos.write(data);
		}
		bos.flush();
		fos.flush();
		end = System.currentTimeMillis();
		bos.close();
		fos.close();
		bis.close();
		fis.close();
		System.out.println("BufferedOutput 사용했을 때 : " + (end-start) + "ms");
}
}
