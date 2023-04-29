
public class quiz08 {
	public static int solution(String s, String w) {
		int answer = 0;

		int cnt = 1;
		for(String word : s.split("\\s+")) {			
			if(word.equals(w)) {
				answer = cnt;
				break;
			}
			cnt++;
		}							
		
		return answer;
	}
	
	public static void main(String[] args) {
		String s = "old macdonald had a farm";
		String w = "macdonald";
		
		int answer = solution(s, w);
		
		System.out.println(answer);
	}
}
