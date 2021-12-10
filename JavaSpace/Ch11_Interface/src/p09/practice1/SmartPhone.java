package p09.practice1;

public class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface {

	@Override
	public void sendCall() {
		System.out.println("따르릉 따르릉~~");

	}

	@Override
	public void receiveCall() {
		System.out.println("전화 왔어요.");
	}
	
	@Override
	public void play() {
		System.out.println("음악연주 합니다.");
	}
	
	@Override
	public void stop() {
		System.out.println("음악연주 중단합니다.");
	}
	
	@Override
	public void sendSMS() {
		System.out.println("문자 보냅니다.");
	}

	@Override
	public void receiveSMS() {
		System.out.println("문자 받습니다.");
	}
	
	public void schedule() {
		System.out.println("일정관리 합니다.");
	}

}
