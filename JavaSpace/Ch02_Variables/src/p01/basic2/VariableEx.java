package p01.basic2;

// identifier, variable 용어에 대한 실습
// 1. identifier(식별자) : program에서 미리 정의된 element(원소)들을 
//	구분하기 위한 이름(name)
//	예 : VariableEx(class 이름), main(method 이름), age(variable 이름)
// 2. Variable(변수) : 값을 변경할 수 있는 식별자
public class VariableEx {

	public static void main(String[] args) {
		int age;
		double radius;
		
		age = 20;
		System.out.println("나이는 " + age + " 입니다.");
		
		radius = 5.0;
		System.out.println("원의 반지름은 " + radius + " 입니다.");
		
		age = 30;
		System.out.println("나이는 " + age + " 입니다.");

		radius = 10.0;
		System.out.println("원의 반지름은 " + radius + " 입니다.");	
	}

}
