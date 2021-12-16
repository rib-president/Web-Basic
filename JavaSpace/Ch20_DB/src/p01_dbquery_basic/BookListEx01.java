package p01_dbquery_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookListEx01 {
	Connection con;
	
	public BookListEx01() {
		// Oracle Database와 연결
		// jdbc:oracle:thin은 사용하는 JDBC드라이버가 thin 타입을 의미, 자바용 오라클
		// xe : 리스너
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang";
		String pwd = "madang";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver is loaded successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("driver is load failure!");
		}
		

		try {
			System.out.println("DBMS와 connection을 수행");
			con = DriverManager.getConnection(url, userid, pwd);
		} catch (SQLException e) {
			System.out.println("database connection failure");
		}
	}
	
	private void sqlRun() {
		String query = "SELECT * FROM book";
		
		try {
			Statement stmt = con.createStatement();
			//executeQuery : select문 실행
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(" BOOK NO\tBOOK NAME\t\tPUBLISHER\tPRICE");
			while(rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t" + rs.getString(3));
				System.out.print("\t" + rs.getInt("price"));
				System.out.println();
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BookListEx01 so = new BookListEx01();
		
		so.sqlRun();		
	}
}
