package quiz05;

import java.util.*;

public class DataProcess {

	private HashMap<String, Integer> countMap;
	private HashMap<String, String> quoteMap;
	private List<Map.Entry<String, Integer>> entryList;
	
	public DataProcess() {
		countMap = new HashMap<>();
		quoteMap = new HashMap<>();
	}
	
	public void count(String id) {
		countMap.put(id, countMap.getOrDefault(id, 0)+1);
	}
	
	public void put(String id, String quote) {
		if(!quoteMap.containsKey(id)) {
			quoteMap.put(id, quote);
		}
	}
	
	public String trim(String response) {
		return response.substring(1, (response.length()-1));
	}
	
	public String[] getSplitData(String response) {
		return response.split("\"|:");
	}
	
	public String getId(String[] arr) {
		return arr[3].substring(0, (arr[3].length()-1));
	}
	
	public String getQuote(String[] arr) {
		return arr[7];
	}
	
	public void sortDesc() {
		entryList = new ArrayList<>(countMap.entrySet());
		entryList.sort((o1, o2) -> countMap.get(o2.getKey()) - countMap.get(o1.getKey()));			
	}
	
	public void print() {
		for(Map.Entry<String, Integer> entry : entryList) {
			System.out.print("count: " + entry.getValue() + " ");
			System.out.print("{'id': " + entry.getKey() + ", ");
			System.out.print("'quote': '" + quoteMap.get(entry.getKey()) + "'}");
			System.out.println();
		}
		System.out.println();
		System.out.println("Total count: " + entryList.stream().mapToInt(a -> a.getValue()).sum());
	}
	
}
