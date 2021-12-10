package p05.system_class;

public class ExitEx {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				if(status != 5) {
					throw new SecurityException();
				}
			}
		});
		
		for(int i=0;i<10;i++) {
			System.out.println(i);
			try {
				System.exit(i);
			} catch (SecurityException e) {
				System.out.println("SecurityException 인스턴스 호출됨");
			}
		}
	}
}
