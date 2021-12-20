package practice_1;

// 1~10000사이에 8이 몇번 나오는가?

public class Question12 {
	static int count = 0;
	public static void main(String[] args) {

		for(int i=1;i<=10000;i++) {
			countEight(i);
		}
		System.out.println(count);
	}
	
	public static void countEight(int num) {
		if(num % 10 == 8) count++;
		if(num > 10) countEight(num / 10);
	}
}