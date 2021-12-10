package practice_4.Question07;

//	MyInteger class 만들고 테스트 하시오.
public class MyInteger {
	private int value;
	
	MyInteger(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean isEven() {
		if(this.value % 2 == 0) {
			return true;
		} else return false;
	}
	
	public boolean isOdd() {
		return !this.isEven();
	}
	
	public boolean equals(int number) {
		if(this.value == number) {
			return true;
		} else return false;
	}
}
