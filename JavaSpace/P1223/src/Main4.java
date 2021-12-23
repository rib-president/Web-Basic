
import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		// Key는 항상 String타입이라고 생각해도됨
		
		HashMap<String, Integer> map = new HashMap<>();
		
		// 핵심 키로 값을 담는다.
		map.put("aaa", 13);
		map.put("bbb", 27);
		map.put("bbb", 16);	// 값이 수정됨
		map.put("ccc", 13);
		
		Integer var = map.get("aaa");
		System.out.println(var);
		
		Integer var2 = map.get("qewrqwerq");
		System.out.println(var2);
	}
}
