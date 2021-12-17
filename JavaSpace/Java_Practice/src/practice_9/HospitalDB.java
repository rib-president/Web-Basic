package practice_9;

import java.util.*;
import java.sql.*;

public class HospitalDB {
	Connection conn;
	
	public HospitalDB() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "hospital";
		String pwd = "hospital";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver is loaded successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("driver is load failure!");
		}
		

		try {
			conn = DriverManager.getConnection(url, userid, pwd);
			System.out.println("database connection is success");
		} catch (SQLException e) {
			System.out.println("database connection failure");
		}
	}
	
	public void selectAll () {
		try {
			String query = "SELECT * FROM Doctors";

			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
						
			System.out.println("\n<Doctors table>");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("순서|doc_id|major_treat|doc_name|doc_gen|doc_phone|doc_email|doc_position");
			System.out.println("-----------------------------------------------------------------------------");
			
			while (rs.next()) {
				System.out.print(rs.getInt(1) + " | ");
				System.out.print(rs.getInt(2) + " | ");
				System.out.print(rs.getString(3) + " | ");
				System.out.print(rs.getString(4) + " | ");
				System.out.print(rs.getString(5) + " | ");
				System.out.print(rs.getString(6) + " | ");
				System.out.print(rs.getString(7) + " | ");
				System.out.print(rs.getString(8) + " | ");
				System.out.println();
			}

			query = "SELECT * FROM Nurses";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			System.out.println("\n<Nurses table>");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("순서|nur_id|major_job|nur_name|nur_gen|nur_phone|nur_email|nur_position");
			System.out.println("-----------------------------------------------------------------------------");
			
			while (rs.next()) {
				System.out.print(rs.getInt(1) + " | ");
				System.out.print(rs.getInt(2) + " | ");
				System.out.print(rs.getString(3) + " | ");
				System.out.print(rs.getString(4) + " | ");
				System.out.print(rs.getString(5) + " | ");
				System.out.print(rs.getString(6) + " | ");
				System.out.print(rs.getString(7) + " | ");
				System.out.print(rs.getString(8) + " | ");
				System.out.println();
			}	
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("employee search error");
		}
	}
	
}
