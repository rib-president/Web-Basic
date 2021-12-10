package practice_5.Question02;

public class Student extends Person {
	private static final int FRESHMAN = 1;
	private static final int SOPHOMORE = 2;
	private static final int JUNIOR = 3;
	private static final int SENIOR = 4;
	private int status;
	
	public Student(String name, String address, String phone, String email, int status) {
		super(name, address, phone, email);
		switch(status) {
			case 1:
				this.status = FRESHMAN;
				break;
			case 2:
				this.status = SOPHOMORE;
				break;
			case 3:
				this.status = JUNIOR;
				break;
			case 4:
				this.status = SENIOR;
				break;				
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return super.toString() + ", status = " + status;
	}
}
