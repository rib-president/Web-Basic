package practice_9;

import java.util.*;
import java.sql.*;

public class HospitalEx {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		HospitalDB hospital = new HospitalDB();
		while(true) {
			System.out.println("========================================================");
			System.out.println("1.전체 조회 | 2.의사 추가 | 3.의사 정보 수정 | 4.의사 삭제 | 5.종료");
			System.out.println("========================================================");
			
			System.out.print("메뉴 선택 > ");
			int menu = input.nextInt();
			input.nextLine();
			
			switch(menu) {
				case 1:
					System.out.println("===전체 Table 조회===");
					hospital.selectAll();
					break;
					
				case 2:
					System.out.println("===Doctors table insert===");
					int nextVal = hospital.getNextval("doctors");
					if(nextVal != -1) {
						Doctors doctors = new Doctors(nextVal);
					
						System.out.print("doc_id : ");
						doctors.setDoc_id(input.nextInt());
						input.nextLine();
						System.out.print("major_treat : ");
						doctors.setMajor_treat(input.nextLine());
						System.out.print("doc_name : ");
						doctors.setDoc_name(input.nextLine());
						System.out.print("doc_gen : ");
						doctors.setDoc_gen(input.nextLine().charAt(0));
						System.out.print("doc_phone : ");
						doctors.setDoc_phone(input.nextLine());
						System.out.print("doc_email : ");
						doctors.setDoc_email(input.nextLine());
						System.out.print("doc_position : ");
						doctors.setDoc_position(input.nextLine());	
			
						if(hospital.insertDoctors(doctors)) {
							System.out.println("insert 성공!");
						} else System.out.println("insert 실패");
					} else System.out.println("get Nextval 실패");
					break;
					
				case 3:
					System.out.println("===Doctors table update===");
					System.out.print("찾는 조건 컬럼 : ");
					String searchCol = input.nextLine();
					System.out.print("찾는 조건 값 : ");
					String searchVal = input.nextLine();
					System.out.print("바꿀 컬럼 : ");
					String updateCol = input.nextLine();
					System.out.print("바꿀 값 : ");
					String updateVal = input.nextLine();
					
					// ArrayList<Doctors> docList = hospital.searchDoctors(searchCol, searchVal);
					if(hospital.update("doctors", searchCol, searchVal, updateCol, updateVal)) {
						System.out.println("update 성공!");
					} else System.out.println("update 실패");
					break;
					
				case 4:
					System.out.println("===Doctors table delete===");
					System.out.println("전부 다 지울 경우 1을 두 번 입력하세요.");
					System.out.print("지울 조건 컬럼 : ");
					String searchCol1 = input.nextLine();
					System.out.print("지울 조건 값 : ");
					String searchVal1 = input.nextLine();
					
					if(hospital.delete("doctors", searchCol1, searchVal1)) {
						System.out.println("delete 성공!");
					} else System.out.println("delete 실패");
				case 5:
					System.out.println("===프로그램 종료===");
					System.exit(1);
			}
			System.out.println();
		}
	}
}
