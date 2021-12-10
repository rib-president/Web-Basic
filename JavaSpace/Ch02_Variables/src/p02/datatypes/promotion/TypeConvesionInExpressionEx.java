package p02.datatypes.promotion;


//	산술연산 (+, -, *, /)에서의 데이터 타입 자동컨버젼(conversion)
//	용어설명  sum = b1 + b2 (b1, b2를 피연산자(operand)라 부르고,
//	+을 연산자(operator)라고 부름
//	1. int 연산자(4bytes)보다 크기가 작은 정수형 타입(byte, char, short)의
//	피연산자간에 산술연산을 하면 피연산자를 int연산자로 자동형변환(promotion)하여
//	산술연산을 함.
//	2. long type 피연산자와 long type보다 크기가 작은 정수형 타입
//	(byte, char, short, int)의 피연산자간에 산술연산을 하면 피연산자를 long type
// 연산자로 자동형변환(promotion)하여 산술연산을 함.
//	3. float형과 정수형(byte, char, short, int, long)과 산술연산
//	=> float type으로 자동 형변환한 뒤 산술 연산
//	4. double형과 정수형(byte, char, short, int, long)/float과 산술연산
//	=> double type으로 자동 형변환한 뒤 산술 연산
public class TypeConvesionInExpressionEx {

	public static void main(String[] args) {
		byte b1 = 42;
		byte b2 = 10;
		byte sum;
		byte minus;
		long l1 = 15;
		long result;
		
		//	기계어 명령어 관점에서 보면
		//	1. b1, b2를 각각 int type으로 자동형변환(1byte => 4bytes)
		//	2. int type으로 변경된 b1과 b2를 연산
		//	3. int type의 덧셈 결과를 byte type인 sum에 넣으면서 에러 발생
		sum = (byte) (b1 + b2);
		System.out.println("sum = " + sum);	
		minus = (byte) (b1 - b2);
	
		//	기계어 명령어 관점에서 보면
		//	1. b1, l1를 각각 long type으로 자동형변환(1byte => 8bytes)
		//	2. long type으로 변경된 b1과 l1를 연산
		//	3. long type의 덧셈 결과를 byte type인 sum에 넣으면서 에러 발생
		sum = (byte) (b1 + l1);
		
		result = b1 + l1;
	}

}
