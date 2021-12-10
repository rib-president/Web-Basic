package practice_2;

//	Math.random()을 이용하여 1~12 범위의 숫자를 생성한 뒤
//	switch문을 사용하여 해당 월을 출력하시오.
public class Question01 {
	public static void main(String[] args) {
		int month = (int)(Math.random()*12) + 1;
		
		switch (month) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				System.out.println(month + "월 입니다.");
		}
	}
}
