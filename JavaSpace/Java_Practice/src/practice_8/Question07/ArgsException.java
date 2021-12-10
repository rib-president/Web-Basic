package practice_8.Question07;

public class ArgsException extends Exception {
	private int argsNumber;
	
	ArgsException(String s) {
		super(s);
	}
	
	public int getArgsNumber() {
		return argsNumber;
	}
	
	public void setArgsNumber(int argsNumber) {
		this.argsNumber = argsNumber;
	}
}
