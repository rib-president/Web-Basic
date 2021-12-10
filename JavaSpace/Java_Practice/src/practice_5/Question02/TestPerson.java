package practice_5.Question02;

public class TestPerson {
	public static void main(String[] args) {
		Person person = new Person("박사람", "대한민국", "010-123-456", "human@people.kr");
		Student student = new Student("김학생", "서울", "02-119", "student@gmail.com", 3);
		Employee employee = new Employee("일개미", "군산", "02-111", "ant@naver.com", 356, 3500);
		Faculty faculty = new Faculty("이교수", "속초", "031-555", "professor@yahoo.com", 50, 7000,
										"9 to 6", "1");
		Staff staff = new Staff("오스탭", "불명", "???-???", "anonymous@???", 99, 10000, "프리랜서");
			
		System.out.println(person.toString());
		System.out.println("------------------------------------");
		System.out.println(student.toString());
		System.out.println("------------------------------------");
		System.out.println(employee.toString());
		System.out.println("------------------------------------");
		System.out.println(faculty.toString());
		System.out.println("------------------------------------");
		System.out.println(staff.toString());
	}
}
