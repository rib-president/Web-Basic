import java.net.*;
import java.util.*;
import java.io.*;

public class Server1 {
	public static void main(String[] args) throws Exception {
		System.out.println("서버 가동 시작...");
		ServerSocket ss = new ServerSocket(7777);
		
		Socket socket = ss.accept();
		
		System.out.println("누군가 접속했습니다.");
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		String value = dis.readUTF();
		
		System.out.println("받은 값 : " + value);
		
		System.out.print("전송할 값을 입력하세요 >");
		Scanner scn = new Scanner(System.in);
		String writeValue = scn.nextLine();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		dos.writeUTF(writeValue);
		
		socket.close();
	}
}
