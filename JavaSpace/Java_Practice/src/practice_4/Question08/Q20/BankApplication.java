package practice_4.Question08.Q20;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	private static int count;
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = scanner.nextInt();
			scanner.nextLine();
			
			if(selectNo == 1) {
				createAccount();
			} else if(selectNo == 2) {
				accountList();
			} else if(selectNo == 3) {
				deposit();
			} else if(selectNo == 4) {
				withdraw();
			} else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
	
	//	계좌생성하기
	private static void createAccount() {
		System.out.println("--------");
		System.out.println("계좌생성");
		System.out.println("--------");

		System.out.print("계좌번호: ");
		String ano = scanner.nextLine();
		
		for(int i=0;i<count;i++) {
			if(accountArray[i].getAno().equals(ano)) {
				System.out.println("중복계좌가 이미 존재합니다. 계좌생성 종료");
				return;
			}
		}
		System.out.print("계좌주: ");
		String owner = scanner.nextLine();
		System.out.print("초기입금액: ");
		int balance = scanner.nextInt();
		
		Account account = new Account(ano, owner, balance);
		accountArray[count] = account;
		count++;
		System.out.println("결과: 계좌가 생성되었습니다.");
	}
	//	계좌목록보기
	private static void accountList() {
		System.out.println("--------");
		System.out.println("계좌목록");
		System.out.println("--------");
		
		for(int i=0;i<count;i++) {
			System.out.print(accountArray[i].getAno());
			System.out.print("\t");
			System.out.print(accountArray[i].getOwner());
			System.out.print("\t");
			System.out.print(accountArray[i].getBalance());
			System.out.println();
		}
	}
	//	예금하기
	private static void deposit() {
		System.out.println("--------");
		System.out.println("예금");
		System.out.println("--------");		
		
		System.out.print("계좌번호: ");
		String ano = scanner.nextLine();		
		
		Account account = findAccount(ano);
		if(account.getOwner() != " ") {
			System.out.print("예금액: ");
			int credit = scanner.nextInt();
			if(credit > 0) {
				account.setBalance(account.getBalance()+credit);
				System.out.println("결과: 예금이 성공되었습니다.");
			} else {
				System.out.println("예금액은 0원보다 커야 합니다.");
			}
		} else {
			System.out.println("존재하지 않는 계좌번호입니다.");
		}
	}
	
	//	출금하기
	private static void withdraw() {
		System.out.println("--------");
		System.out.println("출금");
		System.out.println("--------");		
		
		System.out.print("계좌번호: ");
		String ano = scanner.nextLine();		
		
		Account account = findAccount(ano);
		if(account.getOwner() != " ") {
			System.out.print("출금액: ");
			int credit = scanner.nextInt();
			int balance = account.getBalance();
			if(credit > 0 && credit <= balance) {
				account.setBalance(balance-credit);
				System.out.println("결과: 출금이 성공되었습니다.");
			} else {
				System.out.println("출금액은 0원보다 크고 잔고보다 작거나 같아야 합니다.");
			}
		} else {
			System.out.println("존재하지 않는 계좌번호입니다.");
		}		
	}
	
	//	Account 배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {
		for(int i=0;i<count;i++) {
			if(accountArray[i].getAno().equals(ano)) {
				return accountArray[i];
			}
		}
		return new Account(" ", " ", 0);
	}
}
