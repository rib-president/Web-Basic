package p01.practice;

//	return value type이 void인 method 사용 사례
//	1.실제 사용 예 : 특정 정보를 입력, 출력하는 목적으로 method를 만든 경우
public class TestVoidMethod {
	public static void main(String[] args) {
		System.out.print("등급은 ");
		printGrade(78.5);

		System.out.print("등급은 ");
		printGrade(59.5);
	}
	
	public static void printGrade(double score) {
		if(score >= 90) {
			System.out.println("A 등급입니다.");
		} else if(score >= 80) {
			System.out.println("B 등급입니다.");			
		} else if(score >= 70) {
			System.out.println("C 등급입니다.");
		} else if(score >= 60) {
			System.out.println("D 등급입니다.");
		} else {
			System.out.println("F 등급입니다.");
		}
	}
}
