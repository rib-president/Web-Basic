package p04.object_finalize;

public class FinalizeEx {
	public static void main(String[] args) {
		Employee emp;
		
		emp = new Employee(1);
		emp = null;
		emp = new Employee(2);
		emp = null;
		emp = new Employee(3);
		emp = null;
		emp = new Employee(4);
		
		System.out.println("emp가 최종적으로 참조하는 사원번호: " + emp.id);
		
		System.gc();
		}
}
