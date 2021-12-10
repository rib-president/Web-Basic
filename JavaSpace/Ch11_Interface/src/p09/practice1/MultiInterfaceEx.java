package p09.practice1;

public class MultiInterfaceEx {
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone();
		
		sp.printLogo();
		sp.sendCall();
		sp.play();
		System.out.println("3과 5를 더하면 " + sp.calculate(3, 5));
		sp.schedule();
		sp.receiveCall();
		sp.receiveSMS();
		sp.stop();
	}
}
