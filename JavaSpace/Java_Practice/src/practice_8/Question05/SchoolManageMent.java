package practice_8.Question05;

import java.util.*;

public class SchoolManageMent {
	static List<Person> mems = new ArrayList<>();
	
	void printInfo() {
		for(Person person : mems) {
			person.sayInfo();
			System.out.println();
		}
	}
	
	void printRandomInfo() {
		Random random = new Random();
		int idx = random.nextInt(mems.size()-1);
		
		mems.get(idx).sayInfo();
		System.out.println();
	}
}
