package p04.object_finalize;

public class Employee {
	public int id;
	
	public Employee(int id) {
		this.id = id;
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Employee id : " + id + "가 메모리에서 제거됨");
	}
}
