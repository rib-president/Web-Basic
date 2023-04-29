
public class quiz07 {
	public static int[] solution(long a) {
		int[] answer = new int[10];
				
		while(a > 0) {
			int tmp = (int) (a % 10);
			a /= 10;
			answer[tmp]++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		long a = 1333555550;
		
		int[] answer = solution(a);
		
		for(int an : answer) {
			System.out.println(an);
		}
	}
}
