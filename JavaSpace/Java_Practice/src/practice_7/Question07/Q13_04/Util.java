package practice_7.Question07.Q13_04;

public class Util {
	public static <T extends Pair<?, ?>> Integer getValue(T t, String key) {
		if(t.getKey().equals(key)) {
			return (Integer) t.getValue();
		}
		return null;
	}
}
