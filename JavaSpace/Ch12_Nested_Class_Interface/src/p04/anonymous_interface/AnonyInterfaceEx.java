package p04.anonymous_interface;

public class AnonyInterfaceEx {
	public static void main(String[] args) {
		AnonyInterface ai = new AnonyInterface();
		ai.rc.turnOn();

		ai.method1();
		
		ai.method2(new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("SmartTV를 켭니다.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("SmartTV를 끕니다.");
			}
		});
		
	}
}
