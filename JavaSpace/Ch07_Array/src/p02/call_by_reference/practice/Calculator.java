package p02.call_by_reference.practice;

//	main method의 String[] args => 변수이름이 args이고, 배열원소의 type이
//	String인 배열
//	args : 프로그램 외부에서 데이터를 프로그램 내부로 넘길 때 사용하는 변수
//	- 외부에서 숫자로 입력했더라도 프로그램 내부로 전달될 때 String으로 변환돼 넘어옴
//	외부에서 숫자 데이터 + 연산자 + 숫자데이터를 넘기면, 사칙연산하는 프로그램
//	예를 들면, 외부에서 2 + 3 => 5, 2 * 5 => 10
public class Calculator {
	public static void main(String[] args) {
//		for(int i=0;i<args.length;i++) {
//			System.out.println("args[" + i + "] = " + args[i]);
//		}
//		
//		System.out.println("end of calculation");
		
		if(args.length != 3) {
			System.out.println("Calculator 사용법 : 피연산자 연산자 피연산자 "
					+ "(예 : 2 + 5)");
			System.exit(1); 	// application을 강제 종료
		}
		
		int result = 0;
		
		switch (args[1].charAt(0)) {
		case '+':
			result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
			break;
		case '-':
			result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
			break;
		case 'x':
			result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
			break;
		case '/':
			result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
			break;
		case '%':
			result = Integer.parseInt(args[0]) % Integer.parseInt(args[2]);
			break;			
		}
		System.out.println(args[0] + " " + args[1] + " " + args[2] +
				" = " + result);
	}
}
