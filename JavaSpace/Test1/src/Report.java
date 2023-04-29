import java.util.*;

public class Report {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        HashMap<String, HashSet<String>> map = new HashMap<>();
        
        for(String r : report) {
            String[] splitR = r.split(" ");
            if(!map.containsKey(splitR[1])) {
            	HashSet<String> value = new HashSet<String>();
            	value.add(splitR[0]);
            	map.put(splitR[1], value);
            } else {
            	map.get(splitR[1]).add(splitR[0]);
            }
        }
        
        HashMap<String, Integer> reportMap = new HashMap<String, Integer>();
        for(String key : map.keySet()) {        	
        	if(map.get(key).size() >= k) {
        		for(String id : map.get(key)) {        			
        			reportMap.put(id, reportMap.getOrDefault(id, 0)+1);
        		}
        	}
        }
        
        answer = new int[id_list.length];
        for(int i=0;i<id_list.length;i++) {
        	if(!reportMap.containsKey(id_list[i])) {
        		answer[i] = 0;
        		continue;
        	}
        	answer[i] = reportMap.get(id_list[i]);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    	String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    	int k = 2;
    	
    	int[] answer = solution(id_list, report, k);
    	
    	for(int a : answer) {
    		System.out.println("hi : " + a);
    	}
    }
}