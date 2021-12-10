package p02.anonymous_instance;

public class RemoteEx {
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl() {
			int volume;
			
			@Override
			public void turnOn() {
				System.out.println("Anonymous(익명) 객체 - 전원 켭니다.");				
			}
			
			@Override
			public void turnOff() {
				System.out.println("Anonymous(익명) 객체 - 전원 끕니다.");				
			}
			
			@Override
			public void setVolume(int volume) {
				this.volume = volume;
				System.out.println("Anonymous(익명) 객체 - volume = " + 
						this.volume);
			}
		};
		
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(5);
	}
}
