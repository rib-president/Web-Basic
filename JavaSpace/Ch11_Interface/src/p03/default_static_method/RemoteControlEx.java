package p03.default_static_method;

public class RemoteControlEx {
	public static void main(String[] args) {
		RemoteControl rc;
		
		rc = new Television();
		rc.turnOn();
		rc.setVolume(5);
		rc.setMute(true);
		rc.turnOff();	

		RemoteControl.changeBattery();
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(7);
		rc.setMute(false);
		rc.turnOff();
	}
	
}
