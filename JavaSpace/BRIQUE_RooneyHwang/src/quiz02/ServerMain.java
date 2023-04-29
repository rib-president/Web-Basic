package quiz02;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

// ServerMain을 먼저 실행한 뒤, ClientMain을 실행해주세요
public class ServerMain {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int cnt = 0;
		
		try {
			serverSocket = new ServerSocket(56768);
			Socket socket = serverSocket.accept();
			
			System.out.println("Connected by ('127.0.0.1', 56768)");
			
			while(true) {
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				cnt++;
				String message = dis.readUTF();
				
				if(message.equals("Q")) {
					socket.close();
					System.out.println("클라이언트 연결 종료 요청");
					break;					
				}
				
				ServerThread serverThread = new ServerThread(socket, message, cnt);
				serverThread.start();				
			}

		} catch(Exception e) {
			System.out.println("서버 가동 익셉션 ] " + e.getMessage());
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				System.out.println("서버 소켓 해제 익셉션 ] " + e.getMessage());
			}
			
		}
	}
}