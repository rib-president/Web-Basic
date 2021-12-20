
public class Main2 {
	public static void main(String[] args) {
		int a = 10;
		
		StudentData st1 = new StudentData();
		StudentData st2 = new StudentData();
		
		st1.v1 = 10;
		st2.v2 = 30;
		
		st1 = null;	//garbage가 됨
		
		st1 = new StudentData();
		st2 = new StudentData();
		
		st1.v1 = 30;
		st2.v1 = 50;
				
		System.out.println(st1.v1);
		System.out.println(st2.v1);
		
		st1 = st2;	// 이전에 st1이 참조하는 객체는 참조를 잃음(garbage)
		
		st1.v1 = 100;
		st2.v1 = 200;
		
		System.out.println(st1.v1);	// 200
		System.out.println(st2.v1);	// 200
		
		StudentData st3 = null;
		{
			StudentData st4 = new StudentData();
			StudentData st5 = new StudentData();
			
			st3 = st5;	
		} // scope가 닫혀도 st3에 대입된 StudentData() 객체는 소멸되지 않음
		
		int[] arr1 = new int[3];
		
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		
		arr1 = null;	// 참조를 잃음(garbage)
		
		StudentData[] arr = new StudentData[3];
		
		arr[0] = new StudentData();
		arr[1] = new StudentData();
		arr[2] = new StudentData();
		
		arr[1].v2 = 50;
		
		arr[0] = null;	// 참조를 잃음(garbage)
		
		arr = null;	// 참조를 잃음(garbage)
		
		StudentData[] tttt = test();
		
		tttt[2].v2 = 20;
		System.out.println(tttt[1].v2);

	}
	
	public static StudentData[] test() {
		StudentData[] arr = null;
		
		arr = new StudentData[3];
		
		arr[0] = new StudentData();
		arr[1] = new StudentData();
		arr[2] = new StudentData();
		
		arr[1].v2 = 50;
		
		arr[0] = null;
		
		return arr;
	}
}

class StudentData {
	int v1;
	int v2;
}