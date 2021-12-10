package p06.class_promotion;

public class Student extends Person {
	String grade;
	String dept;
	
	public Student(String name) {
		super(name);
	}
	
	public void printStudentInformation() {
		System.out.println("Student method 실행");
	}	
}
