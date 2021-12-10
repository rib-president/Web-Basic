package practice_8.Question01_02;

public class Question01 {
	public static void main(String[] args) {
		//    *
		//   ***
		//  *****
		// *******
		//*********		
		int auxiliary = 0;
		for(int i=5;i>0;i--) {
			for(int j=1;j<10;j++) {
				if(i <= j && (i+auxiliary) >= j) {
					System.out.print("*");
				}else System.out.print(" ");
			}
			System.out.println();
			auxiliary += 2;
		}
		System.out.println();
		
		//*********
		// *******
		//  *****
		//   ***
		//    *
		for(int i=0;i<5;i++) {
			for(int j=1;j<10;j++) {
				if(j>i && (j-i) < auxiliary) {
					System.out.print("*");
				} else System.out.print(" ");
			}
			System.out.println();
			auxiliary -= 2;
		}
		System.out.println();
		
		//    *
		//   ***
		//  *****
		// *******
		//*********	
		//*********
		// *******
		//  *****
		//   ***
		//    *
		for(int i=5;i>0;i--) {
			for(int j=1;j<10;j++) {
				if(i <= j && (i+auxiliary) >= j) {
					System.out.print("*");
				}else System.out.print(" ");
			}
			System.out.println();
			auxiliary += 2;
		}
		for(int i=0;i<5;i++) {
			for(int j=1;j<10;j++) {
				if(j>i && (j-i) < auxiliary) {
					System.out.print("*");
				} else System.out.print(" ");
			}
			System.out.println();
			auxiliary -= 2;
		}			
	}
}
