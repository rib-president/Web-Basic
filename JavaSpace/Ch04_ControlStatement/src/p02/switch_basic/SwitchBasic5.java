package p02.switch_basic;

public class SwitchBasic5 {
	public static void main(String[] args) {
		int original_score = 79;
		int converted_score;
		
		converted_score = original_score / 10;
	
		switch(converted_score) {
			case 10:
			case 9:
				System.out.println("A 등급 입니다.");
				break;
			case 8:
				System.out.println("B 등급 입니다.");
				break;
			case 7:
				System.out.println("C 등급 입니다.");
				break;
			case 6:
				System.out.println("D 등급 입니다.");
				break;
			default:
				System.out.println("F 등급 입니다.");
				break;				
		}
	}
}
