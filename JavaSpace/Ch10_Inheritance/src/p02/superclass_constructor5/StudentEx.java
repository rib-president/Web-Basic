package p02.superclass_constructor5;

public class StudentEx {
	public static void main(String[] args) {
		Student s = new Student("홍길동", "123456-1234567", 1);
		
		System.out.println("이름 : " + s.name);
		System.out.println("주민등록번호 : " + s.ssn);
		System.out.println("학생번호 : " + s.studentNo);
	}
}
