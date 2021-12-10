package practice_8.Question04;

public class AirConUse {
	public static void main(String[] args) {
		// 객체생성
		AirCon airCon = new AirCon();
				
		// 변수 사용
		airCon.color = "White";
		airCon.temp = 10;
		airCon.price = 10000;
		
		// 메소드 사용
		airCon.tempUp();
		System.out.println("airCon.temp = " + airCon.temp + ", airCon.color = " + airCon.color
				+ ", airCon.price = " + airCon.price + "원");
		airCon.powerOn();
		airCon.powerOff();
		airCon.tempDown();
		System.out.println("airCon.temp = " + airCon.temp + ", airCon.color = " + airCon.color
				+ ", airCon.price = " + airCon.price + "원");
	}
}
