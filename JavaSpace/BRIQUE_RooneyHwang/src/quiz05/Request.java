package quiz05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Request {
	private final String targetURL = "http://codingtest.brique.kr:8080/random";
	
	private URL url;
	private HttpURLConnection httpConn;
	
	public Request() {
		try {
			url = new URL(targetURL);
			httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("GET");
			httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			httpConn.setDoOutput(true);
		} catch (MalformedURLException e) {
			System.out.println("올바르지 않은 형태의 URL 입니다 ]" + e.getMessage());
		}catch (IOException e) {
			System.out.println("커넥션 익셉션 ] " + e.getMessage());
		}	
	}
	
	public String call() {
		BufferedReader input;
		StringBuffer buffer = null;
		try {
			input = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

			String line;
			buffer = new StringBuffer();
			while((line = input.readLine()) != null) {
				buffer.append(line);
			}
			
		} catch (IOException e) {
			System.out.println("입출력 익셉션 ] " + e.getMessage());
		}

		return buffer.toString();		
	}
	
}
