package p02.call_by_reference.practice;

public class ArrayReverse2 {
	public static void main(String[] args) {
		int[] list = {1, 2, 3, 4, 5};
		
		System.out.println("list의 주소 = " + System.identityHashCode(list));
		reverse(list);
		System.out.println("reverse method 호출 후의 list의 주소 = " + System.identityHashCode(list));
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i] + " ");
		}
	}
	
	public static void reverse(int[] list) {
		int[] newList = new int[list.length];
		System.out.println("newList 주소 = " + System.identityHashCode(newList));
		System.out.println("reverse method의 List 주소 = " + System.identityHashCode(list));

		for(int i=0;i<list.length;i++) {
			newList[i] = list[list.length - 1 - i];
		}
		
		list = newList;

	}
}
