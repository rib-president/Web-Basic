package quiz02;

import java.io.DataInputStream;
import java.net.Socket;

class RecvDataThread extends Thread {
	private Socket socket;
	private int cnt;
	
	RecvDataThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		cnt = 0;
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			while(true) {
				cnt++;
				String message = dis.readUTF();
				System.out.println("\nReceived: " + message + "(" + cnt + ")");
			}
		} catch(Exception e) {
			System.out.println("리시브 익셉션 또는 소켓 종료 ] " + e.getMessage());
		}
	}
}
