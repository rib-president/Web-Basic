package p04.hashset_ex2;

import java.util.*;

public class HashSetEx {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		Member m1 = new Member("홍길동", 30);
		Member m2 = new Member("홍길동", 30);
		
		System.out.println(System.identityHashCode(m1));
		System.out.println(System.identityHashCode(m2));
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		
		
		set.add(m1);
		set.add(m2);
		
		System.out.println("총 원소수 : " + set.size());
	}
}
