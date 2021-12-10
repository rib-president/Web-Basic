package p01.basic;

public class InheritEx2 {
	public static void main(String[] args) {
		StudentWorker sw = new StudentWorker();
		sw.name = "김학생워커";
		sw.work();
		sw.study();
		sw.speak();
		sw.eat();
		sw.sleep();
		sw.walk();
	}
}
