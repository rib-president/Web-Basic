package practice_8.Question03;

import java.util.ArrayList;

public class MyStack extends ArrayList {
	private java.util.ArrayList<Object> list;

	// Constructor
	public MyStack() {
		list = new java.util.ArrayList<Object>();
	}

	// Add a new element to the top of this stack
	public void push(Object o) {
		list.add(0, o);
	}

	// Return the top element in this stack without removing it
	public Object peek() {
		return list.get(0);
	}

	// Return an remove the top element in this stack
	public Object pop() {	
		return list.remove(0);
	}

	// Return a string of all elements in MyStack
	@Override
	public String toString() {
		return list.toString();
	}
}