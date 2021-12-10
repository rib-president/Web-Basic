package p02.anonymous_instance;

public interface RemoteControl {
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	//	abstract method
	public void turnOff();
	public void turnOn();
	public void setVolume(int volume);
}
