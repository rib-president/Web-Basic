package practice_8.Question07;

public class ExceptionTest7 {
	public static void main(String[] args) {
		try {
			if(args.length != 2) {
				ArgsException ae = new ArgsException("인자를 두 개 입력해야 합니다.");
				ae.setArgsNumber(args.length);
				throw ae;
			}
			else {
				int num1 = Integer.parseInt(args[0]);
				int num2 = Integer.parseInt(args[1]);
				
				System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
			}
		} catch(ArgsException a) {
			System.out.println(a.getMessage());
			System.out.println("당신이 입력한 인자 수는 " + a.getArgsNumber() + "개입니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
