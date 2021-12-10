package p01.using_generic;

import p01.not_generic.Apple;

public class BoxEx {
	public static void main(String[] args) {
		Box<String> b1 = new Box<>();
		b1.set("hello");
		String str = b1.get();
		
		Box<Apple> a1 = new Box<Apple>();
		a1.set(new Apple());
		Apple apple = a1.get();
		
		Box<Integer> i1 = new Box<>();
		i1.set(new Integer(10));
		Integer iInstance = i1.get();
	}
}
