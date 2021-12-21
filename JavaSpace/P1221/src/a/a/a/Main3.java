package a.a.a;

public class Main3 {
	public static void main(String[] args) {
		// 계좌 개설
		System.out.println("eawfaefewa");
		
		Account a1 = new Account("한조", 10000);
//		a1.owner = "한조";
//		a1.balance = 10000;
		
		Account a2 = new Account("트레이서", 30000);
//		a2.owner = "트레이서";
//		a2.balance = 30000;
		
		a1.deposit(30000);
		a2.withdraw(10000);
		a2.withdraw(10000);
		a2.withdraw(10000);
		a2.withdraw(10000);
		a2.withdraw(10000);
		
		// 계좌 정보 출력
		a1.printInfo();
		a2.printInfo();

	}
}

class Account {
	private String owner;	// 예금주
	private int balance;	// 잔액
	
	public Account(String owner, int balance) {
		this.owner = owner;
		this.balance = balance;
	}
	
	private boolean checkName(String newName) {
		// ...
		return true;
	}
	
	public void updateOwnerNam(String newName) {
		// 적절한 이름인지 유효성 검사
		if(checkName(newName)) {
			// 모든 검사 통화하면
			this.owner = newName;			
		}
	}
	
	public void deposit(int value) {
		balance += value;
	}
	
	public void withdraw(int value) {
		if(value > balance) {
			System.out.println("error] 잔액이 부족합니다. 취소되었습니다.");
			return;
		}
		balance -= value;
	}
	
	public void printInfo() {
		System.out.println("예금주명 : " + owner + ", 잔액 : " + balance);
	}
}