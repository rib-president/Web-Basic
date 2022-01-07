package polymorphism;

import java.util.HashMap;

public class TVContainer {
	private HashMap<String, TV> map = new HashMap<String, TV>();
	
	public TVContainer() {
		map.put("samsung", new SamsungTV());
		map.put("lg", new LgTV());
	}
	
	public TV getTV(String name) {
		return map.get(name);
	}
}