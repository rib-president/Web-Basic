package practice_4.Question06;

//	두 개의 constructor에 대한 parameter 설정하여 BMI 인스턴스를 생성한 뒤
//	getBMI(), getStatus()를 호출하여 비만도 결과를 출력하시오.
public class TestBMI {
	public static void main(String[] args) {
		BMI bmi1 = new BMI("신짱구", 5, 22.9, 1.059);
		System.out.println("이름: " + bmi1.getName() + ", 나이: " + 
				bmi1.getAge() + ", BMI 지수: " + bmi1.getBMI() + 
				", 결과: " + bmi1.getStatus() + "입니다.");

		BMI bmi2 = new BMI("퉁퉁이", 99, 1.81);
		System.out.println("이름: " + bmi2.getName() + ", 나이: " + 
				bmi2.getAge() + ", BMI 지수: " + bmi2.getBMI() + 
				", 결과: " + bmi2.getStatus() + "입니다.");
		
	}
}
