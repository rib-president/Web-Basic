package p01.basic2;

public class PhoneEx {
	public static void main(String[] args) {
		Phone phone = new SamsungPhone();
		phone = new LGPhone();
		phone = new ApplePhone();
		
		phone.sendCall();
		phone.receiveCall();
		
//		SamsungPhone sp = (SamsungPhone)phone;
//		sp.flash();
	}
}
