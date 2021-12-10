package p05.practice;

public class ShowCurrentTime {
	public static void main(String[] args) {
		// 1000ms = 1 second, 1970y01m01d00h00m00s 기준
		long totalMiliSeconds = System.currentTimeMillis();
		System.out.println("totalMiliSeconds = " + totalMiliSeconds);
		
		long totalSeconds = totalMiliSeconds / 1000;
		System.out.println("totalSeconds = " + totalSeconds);		
		
		long currentSecond = totalSeconds % 60;
		System.out.println("currentSecond = " + currentSecond);
		
		long totalMinutes = totalSeconds / 60;
		System.out.println("totalMinutes = " + totalMinutes);		
		
		long currentMinute = totalMinutes % 60;
		System.out.println("currentMinutes = " + currentMinute);		

		long totalHours = totalMinutes / 60;
		System.out.println("totalHours = " + totalHours);		
		
		long currentHour = totalHours % 24 + 9;
		System.out.println("currentHours = " + currentHour);	
		
		System.out.println("현재 시간은 " + currentHour + "시 "
				+ currentMinute + "분 " + currentSecond + "초 입니다.");

	}
}
