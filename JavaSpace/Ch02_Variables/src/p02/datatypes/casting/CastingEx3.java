package p02.datatypes.casting;

public class CastingEx3 {

	public static void main(String[] args) {
		byte b = 0;
		int i = 257;
		double d = 323.142;
		
		System.out.println("byte value = " + b);
		System.out.println("int value = " + i);
		System.out.println("double value = " + d);
		
		
		System.out.println("int에서 byte type으로 형변환하라..");
		b = (byte) i;		
		System.out.println("byte value =" + b);
		
		System.out.println("double에서 int type으로 형변환하라..");		
		i = (int) d;
		System.out.println("int value = " + i);		
		
		System.out.println("double에서 byte type으로 형변환하라..");
		//	기계어 명령어 관점에서 보면
		//	1. 소숫점을 제거 (323.142 => 323으로 데이터 값을 변경)
		//	2. 323을 1 byte만 감기고 나머지 데이터 전부 삭제
		b = (byte) d;
		System.out.println("byte value = " + b);


	}

}
