package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	
	public SamsungTV() {
		System.out.println("Samsung TV 생성됨1");
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void powerOn() {
		System.out.println("삼성 TV --- 전원을 켠다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}

	public void powerOff() {
		System.out.println("삼성 TV --- 전원을 끈다.");
	}

}
