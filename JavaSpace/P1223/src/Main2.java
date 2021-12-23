import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main2 {
	public static void main(String[] args) throws ParseException {
		// 숫자 - 문자 - 날짜의 변환
		int a = 10;
		String b = "20";
		Date c = new Date();
		
		//1.숫자를 문자로 바꾸는 법
		int var1 = 20;
		String var2 = var1 + "";	// 문법을 이용해서 바꿈
		var2 = String.valueOf(var1);	// API를 이용해서 바꿈
		var2 = Integer.toString(var1);	// 특수한 경우아니면 Integer는 안씀
		
		//2.문자를 숫자로 바꾸는 법
		String var3 = "30";
		int var4 = Integer.parseInt(var3);	// 정수로 치환이 불가능한 경우 exception 발생
		
		//3.날짜를 숫자로 바꾸는 법
		Date var5 = new Date();	// 현재 시간
		System.out.println(var5);
		long var6 = var5.getTime();
		
		long tmp = var6 - (1000);	// 현재시간에서 1초 전
		tmp = var6 - (1000*60);	// 현재시간에서 1분 전
		tmp = var6 - (1000*60*60);	// 현재시간에서 1시간 전
		var6 = var6 - (1000*60*60*3);	// 현재시간에서 3시간 전

		//4.숫자를 날짜로 바꾸는 법
		long var7 = 0;
		Date var8 = new Date(var7);
		System.out.println(var8); 	// Thu Jan 01 09:00:00 KST 1970
		
		//5.날짜를 문자로 바꾸는 법(중요)
		Date var9 = new Date();
		System.out.println(var9);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String var10 = sdf.format(var9);
		System.out.println(var10);

		//6.문자를 날짜로 바꾸는 법
		String var11 = "2021-11-15";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date var12 = sdf2.parse(var11);
		System.out.println(var12);

	
	}
}
