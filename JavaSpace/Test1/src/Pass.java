
public class Pass {
	public static void main(String[] args) {
		int x = 5;
		Pass p = new Pass();
		p.doStuff(x);
		System.out.println(" main x = " + x);
	}
	
	void doStuff(int x) {
		System.out.println(" doStuff x = " + x++);
	}
}
