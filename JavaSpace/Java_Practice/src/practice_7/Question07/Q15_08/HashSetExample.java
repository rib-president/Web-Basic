package practice_7.Question07.Q15_08;

import java.util.*;

public class HashSetExample {
	public static void main(String[] args) {
		Set<Student> set = new HashSet<>();
		
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신용권"));
		set.add(new Student(1, "조민우"));
		
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.studentNum + ":" + student.name);
		}
	}
}
