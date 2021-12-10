package p03.anonymous_class;

public class AnonyClassEx {
	public static void main(String[] args) {
		AnonyClass ac = new AnonyClass();
		
		ac.field.wake();
		ac.method1();
		ac.method2(new Person() {
			void study() {
				System.out.println("공부를 합니다.");
			}
			
			@Override
			void wake() {
				System.out.println("9시에 일어납니다.");
				study();
			}
		});
	}
}
