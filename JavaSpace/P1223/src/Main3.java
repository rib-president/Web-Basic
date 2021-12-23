import java.util.*;

public class Main3 {
	public static void main(String[] args) {
		// 자료구조 API
		// 학생이름(String)을 5개 담을 공간을 생성해보자
		String[] arr = new String[5];
		arr[0] = "한조";
		// ....
		arr[4] = "...."; 
		
		ArrayList<String> arr1 = new ArrayList<>();
		arr1.add("한조");
		arr1.add("트레이서");
		arr1.add("한조1");
		arr1.add("한조2");
		arr1.add("한조3");
		
		//arr1.add(2, "메르시");	// 배열에선 값이 대체됨
		
		// 주의 사항 : 자료구조 다룰 때는 아래와 같은 for문 사용X
		for(int i=0;i<arr1.size();i++) {
			System.out.println(arr1.get(i));
		}
		
		// 정답
		for(String data : arr1) {
			System.out.println(data);
		}
		
		arr1.size();	// 개수 확인용
		
		///////////////////////////////////////////////////////////
		
		// 아래 두 개의 명령어는 ArrayList보단 LinkedList에 더 알맞음
		arr1.add(2, null);
		arr1.remove(0);

		
		// 수정은 ArrayList가 더 빠름
		arr1.set(3, null);
		
		// 탐색은 Set이 더 빠름
		arr1.contains("한조");	// 존재 여부 확인
		arr1.remove("한조");
		
	}
}
