package p01.basic4;

public class TestTV {
	public static void main(String[] args) {
		TV tv1 = new TV();
		//	tv를 turnOn 하지 않은 상태에서 channel 또는 volume 변경 불가 
		tv1.setChannel(30);
		tv1.setVolume(3);
		
		tv1.turnOn();
		tv1.setChannel(30);
		tv1.setVolume(3);
		
		tv1.printTVInformation();
		
		TV tv2 = new TV();
		tv2.turnOn();
		tv2.channelUp();
		tv2.channelUp();
		tv2.volumeUp();
		
		tv2.printTVInformation();
		
		tv1.turnOff();
		tv2.turnOff();
		
		tv1.turnOn();
	}
}
