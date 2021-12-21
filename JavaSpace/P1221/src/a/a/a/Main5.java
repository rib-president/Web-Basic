package a.a.a;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main5 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		final String ip ="111.222.111.111";
		
		new Socket(ip, 7777);
		new Socket(ip, 7777);
		new Socket(ip, 7777);
		new Socket(ip, 7777);
		
		//ip = "112.222.111.111";
		
		new Socket(ip, 7777);
		new Socket(ip, 7777);
	
		new Socket(ip, 7777);
	}
}
