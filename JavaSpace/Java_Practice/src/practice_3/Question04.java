package practice_3;

import java.util.Scanner;

//	console에서 3개의 나라이름 문자열을 읽어서 알파벳 내림차순 순서로 정렬해서 출력하시오.
public class Question04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] nations = new String[3];
		
		for(int i=0;i<nations.length;i++) {
			System.out.println("나라이름을 영어로 입력하시오.");
			nations[i] = input.nextLine();
		}
		
		for(int i=0;i<nations.length;i++) {
			for(int j=0;j<i;j++) {
				int compare = (nations[i].toUpperCase()).compareTo(nations[j].toUpperCase());
				if(compare > 0) {
					String temp = nations[j];
					nations[j] = nations[i];
					nations[i] = temp;
				}
			}
		}
		
		for(String nation : nations) {
			System.out.print(nation + " ");
		}
		
		input.close();
	}
}
