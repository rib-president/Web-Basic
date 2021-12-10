package p02.switch_basic;


//	switch문이 if ~ else if ~ else문을 사용하는 것보다는 시스템 유지보수가 유리
public class SwitchBasic4 {
	public static void main(String[] args) {
		char grade = 'D';
		
		switch(grade) {
			case 'A':
			case 'B':
				System.out.println("우수 회원입니다.");
				break;
			case 'C':
			case 'D':
				System.out.println("일반 회원입니다.");
				break;
		}
		
		if ((grade == 'A') || (grade == 'B')) {
			System.out.println("우수 회원입니다.");
		} else if((grade == 'C') || (grade == 'D')) {
			System.out.println("일반 회원입니다.");
		}
	}
}
