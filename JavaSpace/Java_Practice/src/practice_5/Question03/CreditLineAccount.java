package practice_5.Question03;

public class CreditLineAccount extends Account {
	public int creditLine;
	
	public CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
		
	}
	
	//	인출한다 기능을 다시 구현하는 메소드
	@Override
	public int withdraw(int amount) throws Exception {
		if((balance + creditLine) < amount)
			throw new Exception("인출이 불가능합니다.");
		balance -= amount;
		return balance;
	}
}
