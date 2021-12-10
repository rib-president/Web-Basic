package p05.system_class;

//import java.util.Properties;

public class GetPropertyEx {
	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");

		System.out.println("운영체제 이름 : " + osName);
		System.out.println("사용자 이름 : " + userName);
		System.out.println("사용자 홈디렉토리 : " + userHome);
		
//		System.out.println("------------------------------------");
//		System.out.println(" [ key ] \t value");
//		System.out.println("------------------------------------");
//		Properties props = System.getProperties();
	}
}
