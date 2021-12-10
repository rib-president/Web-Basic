package practice_8.Question04;

public class VariableKind {
	// 인스턴스 멤버 변수
	int memVar;
	// static 멤버 변수
	static int staticVar;
	
	public static void main(String[] args) {
		// 로컬 변수
		int localVar;
		
		VariableKind vk1 = new VariableKind();
		System.out.println("vk1.memVar = " + vk1.memVar);
		System.out.println("vk1.staticVar = " + vk1.staticVar);
		System.out.println("VariableKind.staticVar = " + VariableKind.staticVar);
		System.out.println("staticVar = " + staticVar);
		VariableKind vk2 = new VariableKind();
		vk1.staticVar = 20;
		System.out.println("vk2.staticVar = " + vk2.staticVar);
		//System.out.println("localVar = " + localVar);
	}
}
