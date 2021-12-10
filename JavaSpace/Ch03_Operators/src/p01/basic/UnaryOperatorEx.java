package p01.basic;

//	연산자 유형
//	1. 1항 연산자(Unary Operator) : operand(피연산자)가 1개만 있는 경우
public class UnaryOperatorEx {

	public static void main(String[] args) {
		int n1 = 20;
		
		System.out.println("Number = " + n1);
		n1 = +n1;
		System.out.println("Number = " + n1);
		
		n1 = -n1;
		System.out.println("Number = " + n1);
		
		boolean bRun = false;
		System.out.println("boolean 값 = " + bRun);
		
		bRun = !bRun;
		System.out.println("boolean 값 = " + bRun);		

	}

}
