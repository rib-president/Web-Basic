package practice_8.Question03;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Create a MyStack
		MyStack stack = new MyStack();

		// Prompt the user to enter five strings
		System.out.print("Enter five strings: ");
		for (int i = 0; i < 5; i++) {
			stack.push(input.next());	
		}
		
//		String num = (String)(stack.peek());
//		System.out.println("peek 값 : " + num);
//		
//		stack.pop();
//		stack.pop();

		// Display in reverse order
		System.out.println("Stack: " + stack.toString());
		
		input.close();
	}
}
