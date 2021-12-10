package p01.basic;

public class LogicalOperatorEx {

	public static void main(String[] args) {
//		int a1 = 10, a2 =20, a3 = 20, a4 = 0;
		
		int a1 = 10;
		int a2 = 20;
		int a3 = 20;
		int a4 = 0;
		boolean bresult;
		
		System.out.println("a1 < a2 = " + (a1 < a2));
		System.out.println("a2 == a3 = " + (a2 == a3));
		bresult = (a1 < a2) && (a2 == a3);
		System.out.println("breuslt = " + bresult);
		bresult = (a1 < a2) || (a2 == a3);
		System.out.println("breuslt = " + bresult);		
		
		System.out.println("a1 > a2 = " + (a1 > a2));
		System.out.println("a2 == a3 = " + (a2 == a3));
		bresult = (a1 > a2) && (a2 == a3);
		System.out.println("breuslt = " + bresult);		
		
		bresult = (a1 > a2) || (a2 == a3);
		System.out.println("breuslt = " + bresult);		

		bresult = !(a1 > a2);
		System.out.println("breuslt = " + bresult);
		
	}

}
