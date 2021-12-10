package p02.object_class_tostring2;

public class SmartPhoneEx {
	public static void main(String[] args) {
		SmartPhone phone = new SmartPhone("구글", "안드로이드");
		
		System.out.println(phone.toString());
		System.out.println(phone);
	}
}
