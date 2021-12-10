package practice_7.Question07.Q15_09;

import java.util.*;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			int score = map.get(key);
			totalScore += score;
			if(score > maxScore) {
				maxScore = score;
				name = key;
			}
		}
		System.out.println("평균점수: " + (totalScore/map.size()));
		System.out.println("최고점수: " + maxScore);
		System.out.println("최고점수를 받은 아이디: " + name);
	}
}
