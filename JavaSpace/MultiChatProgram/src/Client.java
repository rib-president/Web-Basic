import java.net.*;
import java.util.*;
import java.io.*;

public class Client {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("챗 클라이언트 실행합니다.");
		System.out.println("사용하실 닉네임을 입력해 주세요 >");
		String nickName = scn.nextLine();
		
		System.out.println("서버에 접속을 시도합니다...");
		
		Socket socket = new Socket("localhost", 8977);	// 접속
		
		System.out.println("서버 접속에 성공했습니다.");
		
		System.out.println("*****사용법*****");
		System.out.println("메세지 입력 후 엔터를 쳐주세요.(q=종료)");
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());	// 출력관련 API
		
		// 닉네임 전달
		dos.writeInt(1);	// command(int) = 1 닉네임 전달, 2 메세지 전달, 3 접속 종료 전달
		dos.writeUTF(nickName);
		
		// 응답 쓰레드 생성 및 실행
		RecvDataThread rdt = new RecvDataThread(socket);
		rdt.start();
		
		// 챗 입력
		while(true) {
			String message = scn.nextLine();
			
			if(message.toUpperCase().equals("Q")) {
				// 접속 종료 전달...
				dos.writeInt(3);
				break;
			}
			
			dos.writeInt(2);
			dos.writeUTF(message);
		}
		
		socket.close();
		scn.close();
		
		System.out.println("챗 프로그램 종료. 이용해 주셔서 감사합니다.");
	}

}


class RecvDataThread extends Thread {
	private Socket socket;
	
	RecvDataThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			while(true) {
				String message = dis.readUTF();
				System.out.println(message);
			}
		} catch(Exception e) {
			// socket 종료 됐을 때 정상적으로 탈출하기 위한 catch문
			System.out.println("리시브 쓰레드 익셉션 발생...쓰레드 정상 종료...");
		}
	}
}












