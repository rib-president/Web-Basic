package practice_4.Question04;

//	id 1122, balance 20,000원 account 인스턴스 생성하고 연이율 4.5%로 설정
//	2,500원 withdraw, 3,000원 deposit 실행한 뒤 잔고, 월이자율 출력
public class TestAccount {
	public static void main(String[] args) {
		Account account = new Account(1122, 20000);
		
		account.setAnnualInterestRate(4.5);
		account.withdraw(2500);
		account.deposit(3000);
		System.out.println("잔고는 " + account.getBalance() + "원이며, "
				+ "월이자율은 " + account.getMonthlyInterestRate() + "입니다.");
		System.out.println("한 달 후 이자를 포함한 예상 잔고는: " + 
				(account.getBalance()+account.getMonthlyInterest()) + 
				"원 입니다.");
	}
}
