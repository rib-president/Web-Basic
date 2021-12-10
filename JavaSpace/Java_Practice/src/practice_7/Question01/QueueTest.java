package practice_7.Question01;

import java.util.*;

public class QueueTest {
	public static void main(String[] args) {
		// 큐가 인터페이스이므로, 구현은 linkedlist로
		Queue<String> queue = new LinkedList<>();
		
		queue.add("JAVA");
		queue.add("SCRIPT");
		queue.add("JSP");
		while(!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
	}
}
