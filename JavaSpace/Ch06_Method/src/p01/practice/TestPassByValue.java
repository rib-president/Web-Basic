package p01.practice;

public class TestPassByValue {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 2;
		
		System.out.println("main method - swap전의 num1 = " + num1 + 
				" num2 = " + num2);
		
		swap(num1, num2);
	
		System.out.println("main method - swap후의 num1 = " + num1 + 
				" num2 = " + num2);
			
	}
	
	public static void swap(int n1, int n2) {
		System.out.println("swap method - swap전의 n1 = " + n1 + 
				" n2 = " + n2);
		
		//	swap 코드
		int temp = n1;
		n1 = n2;
		n2 = temp;
		
		System.out.println("swap method - swap후의 n1 = " + n1 + 
				" n2 = " + n2);		
	}
}
