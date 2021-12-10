package p01.not_generic;

public class BoxEx {
	public static void main(String[] args) {
		Box box = new Box();
		box.setObject("홍길동");
		String name = (String) box.getObject();
		
		box.setObject(new Apple());
		Apple apple = (Apple) box.getObject();
		
		box.setObject(new Integer(10));
		Integer i = (Integer) box.getObject();
	}
}
