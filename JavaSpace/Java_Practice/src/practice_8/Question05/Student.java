package practice_8.Question05;

public class Student extends Person {
	private String subject;
	
	Student() {	}
	
	Student(String name, String age, String address, String subject) {
		super(name, age, address);
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	void sayInfo() {
		System.out.println("이름: " + super.getName());
		System.out.println("주소: " + super.getAddress());
		System.out.println("나이: " + super.getAge());
		System.out.println("수강과목: " + this.getSubject());
	}
}
