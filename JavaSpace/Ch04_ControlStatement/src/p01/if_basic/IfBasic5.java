package p01.if_basic;

//	성적 점수를 사용하여, 성적 등급(A,B,C,D,F)을 매기는 경우
//	if, else if, else를 사용하여 다양한 조건에 따라서 명령어 코딩 가능
public class IfBasic5 {
	public static void main(String[] args) {
		int score = 85;
		
		if (score >= 90) {
			System.out.println("A 등급입니다.");
		} else if (score >= 80) {
			System.out.println("B 등급입니다.");
		} else if (score >= 70) {
			System.out.println("C 등급입니다.");
		} else if (score >= 60) {
			System.out.println("D 등급입니다.");
		} else {
			// score < 60
			System.out.println("F 등급입니다.");			
		}
	}
}
