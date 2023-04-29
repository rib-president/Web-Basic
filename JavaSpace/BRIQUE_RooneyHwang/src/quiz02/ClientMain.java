package quiz02;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

// ServerMain을 먼저 실행한 뒤, ClientMain을 실행해주세요.
public class ClientMain {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);	
		Socket socket = null;
		try {
			int cnt = 0;
			socket = new Socket("localhost", 56768);			
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			System.out.println("q 또는 Q 입력 시 종료됩니다.");
			RecvDataThread rdt = new RecvDataThread(socket);
			rdt.start();
			
			while(true) {
				cnt++;
				System.out.print("Send(" + cnt + "): ");
				String message = scn.nextLine();
				
				// q 또는 Q 입력 시 종료
				if(message.toUpperCase().equals("Q")) {
					System.out.println("Q 입력 -> 접속 종료");
					dos.writeUTF("Q");
					break;
				}
				
				dos.writeUTF(message);
			}
			
		} catch (UnknownHostException e) {
			System.out.println("대상이 존재하지 않습니다 ] " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("입출력 익셉션 ] " + e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("소켓 해제 익셉션 ] " + e.getMessage());
			}
			scn.close();
			
		}
	}
}
