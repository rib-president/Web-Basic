package p01.basic;

//	2차원 배열(2 dimensional Array) => table형태의 data를 관리하기에 적합
public class TwoDimArrayBasic {
	public static void main(String[] args) {
		String[][] gPerson = {
								{"1", "박철호", "서울", "회사원"},
								{"2", "김의실", "경남", "공무원"},
								{"3", "오수철", "부산", "연예인"}
							};
		System.out.println("gPerson[0][0] = " + gPerson[0][0]);
		System.out.println("gPerson[1][0] = " + gPerson[1][0]);
		System.out.println("gPerson[2][0] = " + gPerson[0][3]);
	}
}
