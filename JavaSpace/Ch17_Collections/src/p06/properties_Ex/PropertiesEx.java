package p06.properties_Ex;

import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

public class PropertiesEx {
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		String path = PropertiesEx.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path, "utf-8");	// 경로에 한글이 있을 경우 디코딩하여 한글로 복원
		properties.load(new FileReader(path));

		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		System.out.println("driver : " + driver);
		System.out.println("url : " + url);
		System.out.println("username : " + userName);
		System.out.println("password : " + password);
	}
}
