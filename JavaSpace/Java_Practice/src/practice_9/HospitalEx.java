package practice_9;

import java.util.*;
import java.sql.*;

public class HospitalEx {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		HospitalDB hospital = new HospitalDB();
		hospital.selectAll();
	}
}
