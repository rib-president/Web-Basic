package practice_7.Question02_06;

import java.util.*;

public class Question04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int maxValue = 0;
		int maxKey = 0;
		
		while(true) {
			System.out.println("정수를 입력하시오. (0 입력 시 종료)");
			int num = input.nextInt();
			if(num == 0) {
				break;
			}
			if(map.containsKey(num)) {
				int value = map.get(num);
				map.put(num, ++value);
				if(value > maxValue) {
					maxValue = value;
					maxKey = num;
				}
			} else {
				map.put(num, 1);
			}
		}
		
		System.out.println("종료되었습니다.");
		System.out.println("가장 많이 입력된 정수는 : " + maxKey + " 횟수는 : " + maxValue);
		
		input.close();
	}
}
