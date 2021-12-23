import java.net.*;
import java.util.*;
import java.io.*;

public class Client1 {
	public static void main(String[] args) throws Exception {
		System.out.println("클라이언트 가동 시작");
		
		Socket socket = new Socket("localhost", 7777);
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		System.out.print("보낼 값을 입력하세요 >");
		Scanner scn = new Scanner(System.in);
		String writeValue = scn.nextLine();
		
		dos.writeUTF(writeValue);	// 서버쪽에 값을 보내겠다.
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String value = dis.readUTF();
		
		System.out.println("서버로부터 받은 값 : " + value);
		
	}
}
