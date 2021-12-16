package p02_db_dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EmployeeDB {
	Connection con;
	
	public EmployeeDB() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang";
		String passwd = "madang";
		
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("driver load failure!");
//			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
		} catch (SQLException e) {
			System.out.println("Oracle database connection failure");
//			e.printStackTrace();
		}
	}

	public Boolean employeeExist (String emplid, String password) {
		Boolean result = false;
		
		try {
			String query = "SELECT * FROM EMPLOYEE WHERE emplid = ? AND password = ? ";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(emplid));
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
//			if (rs.next() == false) System.out.println("search is null");
//			else System.out.println("search result is true");
			
			while (rs.next()) {
				if ((Integer.toString(rs.getInt(1))).equals(emplid) && ((rs.getString(3)).equals(password))) {
					result = true;
					break;
				}
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("employee search error");
		}
		return result;
	}
	
	public boolean employeeInsert (Employee empl) {
		
		try {
			String query = "insert into employee (emplid, name, password, emailaddr, socialno, dept, adminyn) " + 
					" values ( ?, ?, ?, ?, ?, ?, ? )";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, empl.getEmplid());
			pstmt.setString(2, empl.getName());
			pstmt.setString(3, empl.getPassword());
			pstmt.setString(4, empl.getEmailaddr());
			pstmt.setString(5, empl.getSocialno());
			pstmt.setString(6, empl.getDept());
			pstmt.setString(7, empl.getAdminyn());
			int n = pstmt.executeUpdate();

			// insert문 실행 성공
			if (n != 0) {
				pstmt.close();
				return true;
			}
			// insert문 실행 에러
			else return false;
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("employee insert error");
		}
		return false;
	}
	
	
	public boolean employeeUpdate (Employee empl) {
		
		try {
			String query = "UPDATE employee SET name =?, password=?, emailaddr=?, socialno=?, dept=?, adminyn=?"
								+ "	WHERE emplid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, empl.getName());
			pstmt.setString(2, empl.getPassword());
			pstmt.setString(3, empl.getEmailaddr());
			pstmt.setString(4, empl.getSocialno());
			pstmt.setString(5, empl.getDept());
			pstmt.setString(6, empl.getAdminyn());
			pstmt.setInt(7, empl.getEmplid());
			int n = pstmt.executeUpdate();

			if (n != 0) {
				pstmt.close();
				return true;
			}
			else return false;
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("employee insert error");
		}
		return false;
	}

	
	public boolean employeeDelete (String emplid) {
		
		try {
			String query = "DELETE FROM employee WHERE emplid = ?";
//			String query = "UPDATE employee SET adminyn = 'N' WHERE emplid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, Integer.parseInt(emplid));
			int n = pstmt.executeUpdate();

			if (n != 0) {
				pstmt.close();
				return true;
			}
			else return false;
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("employee insert error");
		}
		return false;
	}	
	
	
	public ArrayList<Employee> employeeSearch (String searchText, int cond) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		try {
			String dbRowId;
			if (cond == 0) dbRowId = "emplid";
			else if (cond == 1) dbRowId = "name";
			else return null;
			
			String query = "SELECT * FROM employee WHERE " + dbRowId + "= ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			if (cond == 0) 
				pstmt.setInt(1, Integer.parseInt(searchText));	// employee id�? �???
			else if (cond == 1) 
				pstmt.setString(1, searchText);					// employee name?��? �???

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee empl = new Employee();
				empl.setEmplid(rs.getInt("emplid"));
				empl.setName(rs.getString("name"));
				empl.setPassword(rs.getString("password"));
				empl.setEmailaddr(rs.getString("emailaddr"));
				empl.setSocialno(rs.getString("socialno"));
				empl.setDept(rs.getString("dept"));
				empl.setAdminyn(rs.getString("adminyn"));
				list.add(empl);
			}

		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("employee insert error");
		}
		return list;
	}	
	
	
	public void close() {
		
		try {
			con.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("connection close error");
		}
	}
	
}
