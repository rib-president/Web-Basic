package practice_1;

// 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 
// 몇까지 더해야 총합이 100이상이 되는지 구하시오.
public class Question08 {
	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
	
		while(sum < 100) {
			if(i % 2 != 0) sum += i;
			else sum += -i;
			 
			i++;
		}
		System.out.println(i-1);
	}
}
