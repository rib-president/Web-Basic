package practice_4.Question05;

//	첫번째 인스턴스 생성 후 speed FAST, radius 10, color yello로 설정
//	두번째 인스턴스 생성 후 speed MEDIUM, radius 5, color blue로 설정
//	두 개의 인스턴스에 대하여 printFanInformation(on, speed, radius, color 출력)
public class TestFan {
	public static void main(String[] args) {
		Fan fan1 = new Fan();
		fan1.setOn(true);
		fan1.setSpeed(Fan.FAST);
		fan1.setRadius(10);
		fan1.setColor("yello");
		fan1.printFanInformation();
		
		Fan fan2 = new Fan();
		fan2.setOn(true);
		fan2.setSpeed(Fan.MEDIUM);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.printFanInformation();
	}
}
