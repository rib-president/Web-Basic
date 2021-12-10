package p07.class_casting;

public class StudentEx {
	public static void main(String[] args) {
		Person p;
		Student s = new Student("홍길동");
		s.printPersonInformation();
		s.printStudentInformation();
		
		//	부모 인스턴스 = 자식 인스턴스 주소를 넣음
		p = s;
		System.out.println(p.name);
		p.printPersonInformation();
		//p.printStudentInformation();
		
		s = (Student)p;
		s.printPersonInformation();
		s.printStudentInformation();
		
//		Person p1 = new Person("홍길동");
//		s = (Student) p1;
//		s.printPersonInformation();
//		s.printStudentInformation();
		
	}
}
