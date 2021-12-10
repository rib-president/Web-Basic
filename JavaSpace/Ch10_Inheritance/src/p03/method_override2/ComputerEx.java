package p03.method_override2;

public class ComputerEx {
	public static void main(String[] args) {
		int r = 10;
		
		Calculator cal = new Calculator();
		System.out.println("원의 면적 : " + cal.areaCircle(r));
		System.out.println();
		
		Computer com = new Computer();
		System.out.println("원의 면적 : " + com.areaCircle(r));
	}
}
