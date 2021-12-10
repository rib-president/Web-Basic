package p01.basic;

//	산술연산 우선순위(프로그래밍 언어 기본 rule)
//	1. = 다음에 잇는 수식에서 왼쪽에서 오른쪽으로 계산
//	2. 왼쪽에서 오른쪽으로 연산을 하되 우선순위가 높은 연산을 먼저 수행
//	괄호 > *, /, % > +, -
public class OperatorPrecedenceEx {

	public static void main(String[] args) {
		int expns = 0;
		
		expns = 5 - 2 + 3 - 6;
		System.out.println("expns = " + expns);
		
		expns = 3 - (4/2) + (8*4) - ((5+2)%3);
		System.out.println("expns = " + expns);
		

	}

}
