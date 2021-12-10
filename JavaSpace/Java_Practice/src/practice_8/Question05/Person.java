package practice_8.Question05;

public abstract class Person {
	private String name;
	private String age;
	private String address;
	
	Person() {	}
	
	Person(String name, String age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	abstract void sayInfo();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
}
