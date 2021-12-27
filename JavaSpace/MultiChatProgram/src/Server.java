import java.util.*;
import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) {
		System.out.println("서버 가동 시작...");
		
		try {
			ServerSocket serverSocket = new ServerSocket(8977);
			MemberManager memberManager = new MemberManager();
			
			while(true) {
				Socket socket = serverSocket.accept();
				
				MemberThread memberThread = new MemberThread(socket, memberManager);
				memberManager.addMember(memberThread);

				System.out.println("누군가 접속함, 현재 인원 : " + memberManager.getMemberCount());

				memberThread.start();
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class MemberManager {
	private ArrayList<MemberThread> list = new ArrayList<>();
	
	public int getMemberCount() {
		return list.size();
	}
	
	public void addMember(MemberThread memberThread) {
		list.add(memberThread);
	}
	
	public void removeMember(MemberThread memberThread) {
		list.remove(memberThread);
	}
	
	public void broadCast(String message) {
		for(MemberThread e : list) {
			e.send(message);
		}
	}
}


class MemberThread extends Thread {
	private String nickName;
	private Socket socket;
	private MemberManager memberManager;
	
	public MemberThread(Socket socket, MemberManager memberManager) {
		this.socket = socket;
		this.memberManager = memberManager;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void send(String message) {
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(message);
		} catch(Exception e) {
			System.out.println("server exception] 1111");
		}
	}
	
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			while(true) {
				int command = dis.readInt();
				
				if(command == 1) {
					String nickName = dis.readUTF();
					this.nickName = nickName;
					
					String message = "[공지] " + nickName + "님이 입장하셨습니다.";
					memberManager.broadCast(message);
					
				} else if(command == 2) {
					String message = dis.readUTF();
					message = nickName + "] " + message;
					
					memberManager.broadCast(message);
				} else if(command == 3) {
					memberManager.removeMember(this);
					
					String message = nickName + "님이 퇴장하셨습니다.";
					memberManager.broadCast(message);
					
					socket.close();
					break;
				}
			}
		} catch(Exception e) {
			//....상대방이 접속 강제 종료...
			memberManager.removeMember(this);
			String message = nickName + "님의 접속이 끊겼습니다.";
			memberManager.broadCast(message);
		}
	}
	
}