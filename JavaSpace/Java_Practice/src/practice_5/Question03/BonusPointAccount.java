package practice_5.Question03;

public class BonusPointAccount extends Account {
	int bonusPoint;
	
	public BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}
	
	//	예금한다 기능을 다시 구현하는 메소드
	@Override
	public void deposit(int amount) {
		balance += amount;
		super.deposit(amount);	// super class의 deposit()호출하여 계산
		bonusPoint += (int)(amount*0.001);
	}
}
