package p04.restricted_generic;

public class Course<T extends Person> {
	private String name;
	private T[] students;
	
	public Course(String name, int capacity) {
		this.name = name;
		//students = new Object[capacity];	generic type을 사용하여 new로 인스턴스 생성 불가
		students = (T[]) (new Person[capacity]);
	}
	
	public String getName() {
		return name;
	}
	
	public T[] getStudents() {
		return students;
	}

	
	public void add(T t) {
		for(int i=0;i<students.length;i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
}
