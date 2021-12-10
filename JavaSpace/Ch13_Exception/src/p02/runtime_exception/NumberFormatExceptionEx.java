package p02.runtime_exception;

public class NumberFormatExceptionEx {
	public static void main(String[] args) {
		String data1 = "100";
		String data2 = "a100";
		
		int val1 = Integer.parseInt(data1);
		int val2 = Integer.parseInt(data2);
		
		int result= val1 + val2;
		System.out.println(data1 + " + " + data2 + " = " + result);
	}
}
