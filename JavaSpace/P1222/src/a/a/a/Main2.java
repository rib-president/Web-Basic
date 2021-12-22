package a.a.a;

public class Main2 {
	public static void main(String[] args) {
		Test1 t1 = null;
		//t1 = new Test1();
		t1 = new RRR();
		Test1 t2 = new TTT();
	}
}


interface Test1{
	//public abstract void testA();
	//abstract void testA();
	public void testA();
	//void testA();
	
	public void testB();
}

class RRR implements Test1 {
	public void testA() {
		System.out.println("RRR");
	}

	public void testB() {
		System.out.println("RRR - B");
	}
}


class TTT implements Test1 {
	public void testA() {
		System.out.println("TTT");
	}

	public void testB() {
		System.out.println("TTT - B");
	}
}