package p04.dowhile_basic;

//	100번 출력하라
//	do~while문의 특징
//	1. do~while은 무조건 한 번은 실행됨
//	2. while은 조건식에 의해 한 번도 실행하지 않을 수 있음
public class DoWhileBasic {
	public static void main(String[] args) {
		int count = 0;
		
		do {
			System.out.println("Java씨, 너무너무 존경합니다.");
			count++;
		} while (count < 10);
	}
}
