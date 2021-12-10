package practice_2;

//	4개의 별 패턴 찍기
public class Question09 {
	public static void main(String[] args) {
		System.out.println("Pattern A");
//		*
//		* *
//		* * *
//		* * * *
//		* * * * *
//		* * * * * *
		for(int i=0;i<6;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
//
		System.out.println("\nPattern B");
//		* * * * * *
//		* * * * * 
//		* * * *
//		* * * 
//		* * 
//		*
		for(int i=0;i<6;i++) {
			for(int j=6;j>i;j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
//
		System.out.println("\nPattern C");
//		          *
//		        * *
//		      * * *
//		    * * * *
//		  * * * * *
//		* * * * * *
		for(int i=6;i>0;i--) {
			for(int j=1;j<=6;j++) {
				if(j<i) {
					System.out.print("  ");
				} else {
					System.out.print(" *");
				}
			}
		System.out.println();	
		}
//
		System.out.println("\nPattern D");
//		* * * * * *	
//		  * * * * *
//		    * * * *
//		      * * *
//		        * *
//			      *		
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				if(j>=i) {
					System.out.print(" *");
				} else {
					System.out.print("  ");
				}
			}
		System.out.println();
		}
		
	}
}
