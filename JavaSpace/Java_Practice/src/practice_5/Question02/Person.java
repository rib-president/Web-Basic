package practice_5.Question02;

public class Person {
	private String name;
	private String address;
	private String phoneNo;
	private String email;
	
	public Person() {
		
	}
	
	public Person(String name, String address, String phone, String email) {
		this.name = name;
		this.address = address;
		this.phoneNo = phone;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNo() {
		return 	phoneNo;

	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "name = " + name + ", address = " + address + 
				", phoneNo = " + phoneNo + ", email = " + email;
	}
}
	
	
