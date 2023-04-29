package quiz03;

import java.sql.*;

public class EmpDB {
	private final String url = "jdbc:mariadb://codingtest.brique.kr:3306/employees";
	private final String username = "codingtest";
	private final String pw = "12brique!@";
	private Connection conn;
	
	public EmpDB() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc 찾기 실패 ] " + e.getMessage());
			return;
		}
		
		try {
			conn = DriverManager.getConnection(url, username, pw);
		} catch (SQLException e) {
			System.out.println("DB 커넥션 실패 ] " + e.getMessage());
		}
	}
	
	public void sqlRun() {
		
		String query = "select e.emp_no, e.first_name, e.last_name, e.gender, e.hire_date, table1.dept_name, t.title, max(salary) as max_salary \r\n"
				+ "from employees e, salaries s, (\r\n"
				+ "	select emp_no, dept_name\r\n"
				+ "	from dept_emp de, departments d \r\n"
				+ "	where de.dept_no = d.dept_no \r\n"
				+ ") table1, titles t\r\n"
				+ "where e.emp_no = s.emp_no\r\n"
				+ "and table1.emp_no = e.emp_no\r\n"
				+ "and t.emp_no = e.emp_no \r\n"
				+ "and e.hire_date >= '2000-01-01'\r\n"
				+ "group by emp_no\r\n"
				+ "order by e.first_name";
		
		Statement stmt = null;
		
		try {
			if(conn != null) {
				stmt = conn.createStatement();				
			} else return;
			
			ResultSet rs = stmt.executeQuery(query);			
			
			System.out.println("----------------------------------------------------------------------------------------------------------------------------");
	        System.out.printf("%10s %15s %15s %5s %15s %20s %20s %15s", "emp_no", "first_name", "last_name", "gender", "hire_date", "dept_name", "title", "max_salary");
	        System.out.println();
			System.out.println("----------------------------------------------------------------------------------------------------------------------------");			
			
			while(rs.next()) {
				
		        System.out.printf("%10s %15s %15s %5s %15s %20s %20s %15s", rs.getInt("emp_no"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"), rs.getString("hire_date"), rs.getString("dept_name"), rs.getString("title"), rs.getString("max_salary"));
		        System.out.println();
			}
			
		} catch (SQLException e) {			
			System.out.println("DB 액세스 에러 ] " + e.getMessage());
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
					conn.close();					
				}
			} catch (SQLException e) {
				System.out.println("자원해제 익셉션 ] " + e.getMessage());
			}
		}
		
	}
	
	public void addTab(String data) {
		if(data.length() < 8) {
			System.out.print("\t");
		}
	}
}
