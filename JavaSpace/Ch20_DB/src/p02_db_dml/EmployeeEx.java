package p02_db_dml;

import java.util.ArrayList;
import java.util.List;

public class EmployeeEx {

	public static void main(String[] args) {
		
		EmployeeDB empDb = new EmployeeDB();
		Boolean check;
		List<Employee> list = new ArrayList<Employee>();
		
		if ( empDb.employeeExist("111111", "abcd") ) {
			System.out.println("조회한 employee가 존재합니다.");
		} else {
			System.out.println("조회한 employee가 테이블에 존재하지 않습니다.");
		}
		
		Employee empl = new Employee(77777, "최한나", "abcd", 
				"rrr@chat.com", "990221-202213", "영업", "N");
		check = empDb.employeeInsert(empl);
		
		if (check) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}
		
		// update test
		empl.setDept("관리");
		check = empDb.employeeUpdate(empl);

		if (check) {
			System.out.println("update 성공");
		} else {
			System.out.println("update 실패");
		}

		
		// delete 
		check = empDb.employeeDelete("111111");
		if (check) {
			System.out.println("delete 성공");
		} else {
			System.out.println("delete 실패");
		}

		
		// select 
		list = empDb.employeeSearch("홍길동", 1);
		
		for (int i=0; i<list.size(); i++) {
			empl = (Employee) list.get(i);
			System.out.println(empl.getName() + " : " + empl.getSocialno());
		}

	}

}
