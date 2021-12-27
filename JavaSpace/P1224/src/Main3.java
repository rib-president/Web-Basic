
public class Main3 {
	public static void main(String[] args) {
		TestData<String, String> t1 = new TestData<>();
		TestData<Integer, Boolean> t2 = new TestData<>();
		
		t1.a = "1";
		t1.d = "안녕";
		t2.a = 3;
		t2.d = true;
		
		ArrayListTest<String> list = new ArrayListTest<String>();
		list.add("한조");
		list.add("한조");
		list.add("한조");
		
		ArrayListTest<StudentData> list2 = new ArrayListTest<>();
		list2.add(new StudentData());
		list2.add(new StudentData());
		list2.add(new StudentData());
	}
}

class TestData<T, E> {
	T a;
	T b;
	int c;
	E d;
}

// 응용 프로그램
class StudentData {
	int score;
	String name;	
}

// 자료구조 API
class ArrayListTest<T> {
	private T[] arr = (T[]) (new Object[10]);
	int count = 0;
	
	public void add(T e) {
		arr[count] = e;
		count++;
	}
}