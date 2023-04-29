package quiz03;

// 함께 첨부드린 JDBC jar 파일을 library에 추가해야 합니다.
public class Main {
	public static void main(String[] args) {
		EmpDB empDB = new EmpDB();
		
		empDB.sqlRun();
	}
}
