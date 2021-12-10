package p01.basic;

public class RemoteControlEx {
	public static void main(String[] args) {
		RemoteControl rc;
		
		//rc = new Television();		// 자동형변환(promotion)
		rc = new Audio();
		
		rc.turnOn();
		rc.setVolume(7);
		rc.turnOff();
	}
}
