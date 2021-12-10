package p04.catchorder;

public class CatchOrderEx {
	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		
		try {
			data1 = args[0];
			data2 = args[1];
			
			int val1 = Integer.parseInt(data1);
			int val2 = Integer.parseInt(data2);
			int result = val1 + val2;
			System.out.println(data1 + " + " + data2 + " = " + result);
			
			Class cls = Class.forName("java.lang.String2");
		}
//		} catch(Exception e) {
//			
//		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
			System.out.println("[실행 방법]");
			System.out.println("Eclipse Run-Run Configuration 메뉴에 들어가서 " 
					+ "num1 num2 입력하세요.");
			return;
		} catch(NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		} catch(ClassNotFoundException e) {
			System.out.println("compile time 관련 exception 에러처리");
		}catch(Exception e) {
			System.out.println("위의 catch에서 나온 Exception 종류 외의 "
					+ "나머지 exception이 발생하면 여기서 처리함");
		} finally {
			System.out.println("숫자 덧셈 처리가 종료되었습니다.");
		}
	}
}
