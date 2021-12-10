package p06.interface_inheritance;

//	Interface 상속(Inheritance)
//	여러 개의 부모 인터페이스를 상속하여 자식 인터페이스 생성 가능
public interface InterfaceC extends InterfaceA, InterfaceB {
	void methodC();
}
