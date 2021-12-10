package p05.java_library;

import java.util.Date;

public class DataEx {
	public static void main(String[] args) {
		Date date = new Date();
		
		System.out.println("1970년 1월 1일 0시 0분 0초 이후의 경과 시간 = "
				+ date.getTime());
		System.out.println(date.toString());
		System.out.println(date);
	}
}
