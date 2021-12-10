package practice_4.Question08.Q1617;

//객체 생성하여 instance메소드 호출 vs 객체 생성하지 않고 static메소드 호출
public class PrinterExample {
	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
		System.out.println("-------");
		Printer.println2(10);
		Printer.println2(true);
		Printer.println2(5.7);
		Printer.println2("홍길동");
	}
}
