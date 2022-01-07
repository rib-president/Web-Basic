package polymorphism;

public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println("소니 스피커 생성됨1");
	}
	
	public void volumeUp() {
		System.out.println("소니 스피커 --- 볼륨을 올린다.");
	}

	public void volumeDown() {
		System.out.println("소니 스피커 --- 볼륨을 내린다.");
	}
}
