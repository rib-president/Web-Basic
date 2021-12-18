package practice_9;

import java.util.*;

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
						try	{
							doctors.setDoc_id(input.nextInt());
						} catch(InputMismatchException e) {
							System.out.println("doc_id must be num value");
							input.nextLine();
							continue;
						}
						input.nextLine();
						System.out.print("major_treat : ");
						doctors.setMajor_treat(input.nextLine());
						System.out.print("doc_name : ");
						doctors.setDoc_name(input.nextLine());
						System.out.print("doc_gen : ");
						char doc_gen = Character.toUpperCase(input.nextLine().charAt(0));
						if(doc_gen == 'M' || doc_gen == 'F') 
							doctors.setDoc_gen(doc_gen);
						else {
							System.out.println("doc_gen error(start with only 'M' or 'F')");
							break;
						}
						System.out.print("doc_phone(NULL 허용) : ");
						String doc_phone = input.nextLine();
						if(!doc_phone.toUpperCase().equals("NULL"))
							doctors.setDoc_phone(doc_phone);							
						else doctors.setDoc_phone(null);
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
					System.out.print("찾는 조건(WHERE) 컬럼 : ");
					String searchCol = input.nextLine();
					System.out.print("찾는 조건 값 : ");
					String searchVal = input.nextLine();
					System.out.print("바꿀 컬럼(SET) : ");
					String updateCol = input.nextLine();
					System.out.print("바꿀 값(doc_phone만 NULL 허용) : ");
					String updateVal = input.nextLine();
					if(updateVal.toUpperCase().equals("NULL"))
						updateVal = null;
					
					if(hospital.update("doctors", searchCol, searchVal, updateCol, updateVal)) {
						System.out.println("update 성공!");
					} else System.out.println("update 실패");
					break;
					
				case 4:
					System.out.println("===Doctors table delete===");
					System.out.println("전부 다 지울 경우 1을 두 번 입력하세요.");
					System.out.print("지울 조건 컬럼(WHERE) : ");
					String searchCol1 = input.nextLine();
					System.out.print("지울 조건 값 : ");
					String searchVal1 = input.nextLine();
					
					if(hospital.delete("doctors", searchCol1, searchVal1)) {
						System.out.println("delete 성공!");
					} else System.out.println("delete 실패");
					break;
					
				case 5:
					System.out.println("===프로그램 종료===");
					System.exit(1);
			}
			System.out.println();
		}
	}
}
