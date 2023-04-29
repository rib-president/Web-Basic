import java.util.*;
import java.util.stream.Collectors;

class Lotto {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        ArrayList<Integer> lottoList = (ArrayList<Integer>) Arrays.stream(lottos).boxed().sorted().collect(Collectors.toList());
        
        ArrayList<Integer> win_numsList = (ArrayList<Integer>) Arrays.stream(win_nums).boxed().sorted().collect(Collectors.toList());
        
        int same_count = (int) lottoList.stream().filter(a -> win_numsList.contains(a)).count();
        
        int zero_count = (int) lottoList.stream().filter(a -> a == 0).count();
        
        answer[0] = 7 - (same_count + zero_count);
        answer[1] = 7 - same_count;
        
        if(answer[0] == 7) answer[0] = 6;
        if(answer[1] == 7) answer[1] = 6;
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] lottos = {44, 1, 0, 0, 31, 25};
    	int[] win_nums = {31, 10, 45, 1, 6, 19};
    	
    	int[] answer = solution(lottos, win_nums);
    	
    	for(int a : answer) {
    		System.out.println(a);
    	}
    }
}