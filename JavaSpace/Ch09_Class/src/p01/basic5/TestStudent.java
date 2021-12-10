package p01.basic5;

public class TestStudent {
	public static void main(String[] args) {
		Student student = new Student();
		
		System.out.println("name = " + student.name);
		System.out.println("age = " + student.age);
		System.out.println("컴퓨터 전공 = " + student.isComputerMajor);
		System.out.println("gender = " + student.gender);
		
//		int a = student.gender;
//		System.out.println(a);
	}
}
