package p05.system_class;

public class SystemEnvironmentEx {
	public static void main(String[] args) {
		String javaHome = System.getenv("JAVA_HOME");
		
		System.out.println("JAVA_HOME : " + javaHome);
	}
}
