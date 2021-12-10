package p04.catchorder;

public class CatchOrderEx2 {
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
		} catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("배열 인덱스 값을 벗어나거나 숫자로 변환할 수 없는 에러입니다.");
			return;
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
