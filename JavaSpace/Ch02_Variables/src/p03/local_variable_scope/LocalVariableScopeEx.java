package p03.local_variable_scope;

public class LocalVariableScopeEx {
	public static void main(String[] args) {
		int parentNum = 20;
		
		if (parentNum > 10) {
			int childNum = parentNum - 10;
			System.out.println("chileNum = " + childNum);
			System.out.println("parentNum = " + parentNum);
		}

//		System.out.println("chileNum = " + childNum);
		System.out.println("parentNum = " + parentNum);		
		
//		int parentNum2 = parentNum + childNum + 5;
		
		{
			int a = 20;
		}
//		a = 40;
	}
//	parentNum = 20; => main method에서만 생명이 유지되고 있음	
}
