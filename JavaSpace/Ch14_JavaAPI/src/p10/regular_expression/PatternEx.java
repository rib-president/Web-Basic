package p10.regular_expression;

import java.util.regex.Pattern;

public class PatternEx {
	public static void main(String[] args) {
		String regExp = "(010|02)-\\d{3,4}-\\d{4}";
		String data = "010-123-4567";
		
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angle@navercom";
		
		result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}		
	}
}
