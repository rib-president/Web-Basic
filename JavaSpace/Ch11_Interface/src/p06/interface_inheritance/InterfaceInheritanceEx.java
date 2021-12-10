package p06.interface_inheritance;

public class InterfaceInheritanceEx {
	public static void main(String[] args) {
		ImplementationC impl = new ImplementationC();
		
		InterfaceA ia = impl;
		ia.methodA();
//		ia.methodB();
//		ia.methodC();

		InterfaceB ib = impl;
//		ib.methodA();
		ib.methodB();
//		ib.methodC();
		
		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}
