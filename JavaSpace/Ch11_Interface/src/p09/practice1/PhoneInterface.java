package p09.practice1;

public interface PhoneInterface {
	static final int TIMEOUT = 10000;
	
	void sendCall();
	void receiveCall();
	
	default void printLogo() {
		System.out.println("** Phone **");
	}
}
