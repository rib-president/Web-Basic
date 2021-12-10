package p01.vector_ex;

import java.util.Vector;

public class VectorEx {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>();
		
		v.add(5);
		v.add(4);
		v.add(-1);
		
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		
		v.add(1, 100);
		
		//	향상된 for문 사용 가능
		for(Integer i : v) {
			System.out.println(i);
		}
		
		System.out.println("원소 갯수 : " + v.size());
		System.out.println("vector 전체 크기 : " + v.capacity());
		
		for(int i=0;i<10;i++) {
			v.add(i+10);
		}
		System.out.println("원소 갯수 : " + v.size());
		System.out.println("vector 전체 크기 : " + v.capacity());
	}
}
