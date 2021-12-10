package practice_8.Question04;

class Args {
	int x;
	
	void add(int x) {
		x = x + 50;
	}
	
	void add(Args arg) {
		arg.x = arg.x + 40;
	}
	
	void addNew(Args arg) {
		arg = new Args();
	}
	
	void add(int[] arr) {
		arr[0]++;
	}
}

public class ArgsTest {
	/*
	 * 인수 전달 방식 테스트
	 */
	public static void main(String[] args) {
		Args arg = new Args();
		int[] arr = new int[3];
		
		arg.x = 100;
		
		arg.add(arg.x);
		System.out.println("arg.x = " + arg.x);
		
		arg.add(arg);
		System.out.println("arg.x = " + arg.x);
		
		arg.addNew(arg);
		System.out.println("arg.x = " + arg.x);
		
		arg.add(arr);
		System.out.println("arr[0] = " + arr[0]);

	}
}