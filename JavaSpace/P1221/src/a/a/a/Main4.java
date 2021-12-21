package a.a.a;

public class Main4 {
	public static void main(String[] args) {
		PhoneData pd1 = new PhoneData();
		pd1.setName("dddd");
		System.out.println(pd1.getName());
	}
}

//VO(Value Object)
class PhoneData {
	private String name;
	private String number;
	private String birth;
	
	public PhoneData() {
		super();
	}
	public PhoneData(String name, String number, String birth) {
		super();
		this.name = name;
		this.number = number;
		this.birth = birth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	

}