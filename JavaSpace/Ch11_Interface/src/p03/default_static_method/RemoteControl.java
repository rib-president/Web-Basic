package p03.default_static_method;

public interface RemoteControl {
	//	상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//	public abstract method
	void turnOff();
	void turnOn();
	void setVolume(int volume);
	
	//	public default method
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	//	public static method
	static void changeBattery() {
		System.out.println("건전지를 교체합니다.");
	}
}
