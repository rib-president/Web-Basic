package p09.instanceof_basic;

class Person {}
class Student extends Person {}
class Researcher extends Person {}
class Professor extends Researcher {}

public class InstanceofEx {
	public static void main(String[] args) {
		System.out.print("new Student Instance 결과 -> \t");
		printInstanceInformation(new Student());

		System.out.print("new Researcher Instance 결과 -> \t");
		printInstanceInformation(new Researcher());

		System.out.print("new Professor Instance 결과 -> \t");
		printInstanceInformation(new Professor());
	}
	
	public static void printInstanceInformation(Person p) {
		if(p instanceof Person) {
			System.out.print("Person ");
		}
		if(p instanceof Student) {
			System.out.print("Student ");
		}
		if(p instanceof Researcher) {
			System.out.print("Researcher ");
		}
		if(p instanceof Professor) {
			System.out.print("Professor ");
		}
		System.out.println();
	}
}
