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
	
	public int getNextval(String tableName) {
		String seqName = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if(tableName.toUpperCase().equals("DOCTORS")) {
			seqName = "doc_seq";
		}else if(tableName.toUpperCase().equals("NURSES")) {
			seqName = "nur_seq";
		}

		String query = "SELECT " + seqName + ".NEXTVAL FROM dual";
		
		try {		 
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("resource close error");
				e.printStackTrace();
			}
		}		
		return -1;
	}
	
	public boolean insertDoctors(Doctors doctors) {
		String query = "INSERT INTO Doctors VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, doctors.getDoc_seq());
			pstmt.setInt(2, doctors.getDoc_id());
			pstmt.setString(3, doctors.getMajor_treat());
			pstmt.setString(4, doctors.getDoc_name());
			pstmt.setString(5, Character.toString(doctors.getDoc_gen()));
			pstmt.setString(6, doctors.getDoc_phone());
			pstmt.setString(7, doctors.getDoc_email());
			pstmt.setString(8, doctors.getDoc_position());
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			
			if(result != 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(String tableName, String searchCol, String searchVal, String updateCol, String updateVal) {
		String query = "UPDATE " + tableName + " SET " + updateCol + 
				 " = ? WHERE " + searchCol;
		PreparedStatement pstmt = null;
		
		if(searchVal.toUpperCase().indexOf("NOT NULL") != -1)
			query += " IS NOT " + null;
		else if(searchVal.toUpperCase().indexOf("NULL") != -1)
			query += " IS " + null;
		else
			query += " = '" + searchVal + "'";

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, updateVal);
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			
			if(result != 0) {
				return true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String tableName, String searchCol, String searchVal) {
		String query = "DELETE FROM " + tableName + " WHERE " + searchCol;
		PreparedStatement pstmt = null;
		
		if(searchVal.toUpperCase().indexOf("NOT NULL") != -1)
			query += " IS NOT " + null;
		else if(searchVal.toUpperCase().indexOf("NULL") != -1)
			query += " IS " + null;
		else
			query += " = '" + searchVal + "'";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			
			if(result != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Doctors> searchDoctors(String searchCol, String searchVal) {
		String query = "SELECT * FROM Doctors WHERE " + searchCol;
		PreparedStatement pstmt = null;
		
		if(searchVal.toUpperCase().indexOf("NOT NULL") != -1)
			query += " IS NOT " + null;
		else if(searchVal.toUpperCase().indexOf("NULL") != -1)
			query += " IS " + null;
		else
			query += " = '" + searchVal + "'";

		ArrayList<Doctors> docList = new ArrayList<>();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Doctors doctors = new Doctors(rs.getInt(1));
				doctors.setDoc_id(rs.getInt(2));
				doctors.setMajor_treat(rs.getString(3));
				doctors.setDoc_name(rs.getString(4));
				doctors.setDoc_gen(rs.getString(5).charAt(0));
				doctors.setDoc_phone(rs.getString(6));
				doctors.setDoc_email(rs.getString(7));
				doctors.setDoc_position(rs.getString(8));
				docList.add(doctors);
			}			
			return docList;			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("resource close error");
				e.printStackTrace();
			}			
		}
		return docList;
	}
}
