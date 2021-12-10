package practice_5.Question03;

public class PolyMain {
	public static void main(String[] args) {
		Account obj1 = new Account("111-22-3333", "임꺽정", 10000);
		CheckingAccount obj2 = new CheckingAccount("444-55-666", "홍길동", 20000, "5555-666-777-888");
		CreditLineAccount obj3 = new CreditLineAccount("777-22-3333", "김선달", 3000, 2000000);
		BonusPointAccount obj4 = new BonusPointAccount("000-00-00000", "김미영", 0, 0);
		
		try {
			//	다양한 Type의 객체를 가지고 같은 메소드를 호출
			obj1.deposit(20000);
			obj1.withdraw(5000);
	//		obj1.withdraw(7000000);		// 예외발생
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		printAccountInfo(obj1);

		try {
	//		obj2.pay("11", 500);		// 예외발생
			obj2.pay("5555-666-777-888", 500);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		printAccountInfo(obj2);
		try {
	//		obj3.withdraw(5000000);		// 예외발생
			obj3.withdraw(10000);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		printAccountInfo(obj3);
		obj4.deposit(10000);

		printAccountInfo(obj4);
		//System.out.println("보너스점수 : " + obj4.bonusPoint + "점");
		

	}
	//	다양한 타입의 객체를 한 타입(Account obj)의 파라미터 변수로 받는다.
	static void printAccountInfo(Account obj) {
		System.out.println("계좌번호: " + obj.accountNo);
		System.out.println("예금주 이름: " + obj.ownerName);
		System.out.println("잔액: " + obj.balance);
		System.out.println();
	}
}
