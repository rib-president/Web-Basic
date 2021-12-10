package practice_4.Question04;

//	은행계좌 Account class를 만들고 테스트 하시오.
public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	
	Account() {
		
	}
	
	Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		if(annualInterestRate < 0) {
			System.out.println("**마이너스 금리로 설정되었습니다.**");
		}
		this.annualInterestRate = annualInterestRate / 100;
	}
	
	public double getMonthlyInterestRate() {
		return this.getAnnualInterestRate() / 12;
	}
	
	public double getMonthlyInterest() {
		return this.balance * this.getMonthlyInterestRate();
	}
	
	public void withdraw(double money) {
		if(money > 0) {
			if(this.balance < money) {
				System.out.println("잔고 " + balance + "원보다 큰 금액은 출금할 수 없습니다.");
			} else {
				this.balance -= money;
			}
		} else {
			System.out.println("출금액은 0원보다 커야합니다.");
		}
	}
	
	public void deposit(double money) {
		if(money > 0) {
			this.balance += money;
		} else {
			System.out.println("입금액은 0원보다 커야합니다.");
		}
	}
}
