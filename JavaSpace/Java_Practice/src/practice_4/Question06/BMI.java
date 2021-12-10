package practice_4.Question06;

//	체지방 측정 BMI class를 만들고 테스트 하시오.
public class BMI {
	private String name;
	private int age;
	private double weight;
	private double height;
	
	BMI(String name, double weight, double height) {
		this(name, 20, weight, height);
	}
	
	BMI(String name, int age, double weight, double height) {
		this.name = name;
		this.age = Math.abs(age);
		this.weight = Math.abs(weight);
		//	meter 단위로 키를 받기 위해 체크(아무리 커도 3m는 안넘음)
		height = Math.abs(height);
		if(height > 3) {
			height *= 0.01;
		}
		this.height = height;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getBMI() {
		return this.weight / (this.height * this.height);
	}
	
	public String getStatus() {
		double bmi = this.getBMI();
		String result = null;
		
		if(bmi < 18.5) {
			result = "저체중";
		} else if(bmi < 25) {
			result = "정상 체중";
		} else if(bmi < 30) {
			result = "과체중";
		} else {
			result = "비만";
		}
		
		return result;
	}
}
