package quiz02;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ServerThread extends Thread {
	private String message;
	private DataOutputStream dos;
	private int cnt;
	
	public ServerThread(Socket socket, String message, int cnt) {
		this.message = message;
		this.cnt = cnt;
		try {
			this.dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {

			System.out.println("서버 소켓 dos 익셉션 ] " + e.getMessage());
		}
	}

	public void send(String message) {
		try {
			Thread.sleep(3000);
			System.out.println("Send: " + message + "(" + cnt + ")");
			
			dos.writeUTF(message);
		} catch(IOException e) {
			System.out.println("서버 메세지 발송 익셉션] " + e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("슬립 익셉션 ] " + e.getMessage());			
		}
	}
	
	public void run() {
		try {				
			
			System.out.println("Received(" + cnt + "): " + message);
			
			 if(message.equals("Ping")) {
				 message = "Pong";						 
			 }
			send(message);					 				
		} catch(Exception e) {
			System.out.println("클라이언트 강제 종료 ] " + e.getMessage());
		}
	}
}
