package practice_8.Question05;

public class Officer extends Person {
	private String job;
	
	Officer() {	}
	
	Officer(String name, String age, String address, String job) {
		super(name, age, address);
		this.job = job;		
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	void sayInfo() {
		System.out.println("이름: " + super.getName());
		System.out.println("주소: " + super.getAddress());
		System.out.println("나이: " + super.getAge());
		System.out.println("직업: " + this.getJob());
	}
}
