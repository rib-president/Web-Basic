package practice_8.Question05;

import java.util.Scanner;

public class MainEx {
	public static void main(String[] args) {
		SchoolManageMent manage = new SchoolManageMent();
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int command = 0;
		
		SchoolManageMent.mems.add(new Student("김민태", "21", "서울시", "수학"));
		SchoolManageMent.mems.add(new Student("강종민", "24", "경기시", "국어"));
		SchoolManageMent.mems.add(new Student("강현빈", "23", "구리시", "미술"));
		SchoolManageMent.mems.add(new Student("한순민", "22", "하남시", "영어"));
		SchoolManageMent.mems.add(new Officer("김정태", "40", "서울시", "교사"));
		SchoolManageMent.mems.add(new Officer("김민태", "45", "서울시", "행정직원"));
		SchoolManageMent.mems.add(new Officer("이구민", "46", "서울시", "교장"));
		SchoolManageMent.mems.add(new Officer("노태현", "48", "서울시", "사장"));
		
		while(run) {
			System.out.println("메뉴 : 1.전체 인원 출력 2.랜덤하게 인원 출력 3.종료");
			command = sc.nextInt();
			
			switch(command) {
			case 1:
				manage.printInfo();
				break;
			case 2:
				manage.printRandomInfo();
				break;
			case 3:
				run = false;
				break;
			}
		}
		sc.close();
	}
}
