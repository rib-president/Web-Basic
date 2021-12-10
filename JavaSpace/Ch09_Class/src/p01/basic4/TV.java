package p01.basic4;

//	클래스를 만들 때 기본 사양이 있는 경우 field에 초기값을 줄 수 있음
public class TV {
	int channel = 1;
	int volumeLevel = 1;
	boolean on = false;
	
	public TV() {
		
	}
	
	//	TV 켜기
	public void turnOn() {
		on = true;
	}
	//	TV 끄기
	public void turnOff() {
		on = false;
		channel = 1;
		volumeLevel = 1;
	}
	//	TV가 켜져있고 채널 범위(1~120)에 든다면 채널 변경
	public void setChannel(int newChannel) {
		if(on && (newChannel >= 1 && newChannel <= 120)) {
			channel = newChannel;
		} else {
			System.out.println("올바른 채널이 아니어서 채널 변경이 안됩니다.");
		}
	}
	//	TV가 켜져있고 볼륨 범위(1~7)에 든다면 채널 변경	
	public void setVolume(int newVolumeLevel) {
		if(on &&(newVolumeLevel >= 1 && newVolumeLevel <= 7)) {
			volumeLevel = newVolumeLevel;
		} else {
			System.out.println("올바른 볼륨이 아니어서 볼륨 변경이 안됩니다.");
		}
	}
	
	public void channelUp() {
		if(on && channel < 120) {
			channel++;
		}
	}
	
	public void channelDown() {
		if(on && channel > 1) {
			channel--;
		}
	}
	
	public void volumeUp() {
		if(on && volumeLevel < 7) {
			volumeLevel++;
		}
	}
	
	public void volumeDown() {
		if(on && volumeLevel > 1) {
			volumeLevel--;
		}
	}
	
	public void printTVInformation() {
		System.out.println("channel = " + channel + ", volume = " + 
					volumeLevel);
	}
}
