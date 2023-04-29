import java.util.*;

public class Newid {
    public static String solution(String new_id) {
        String answer = "";
        
        List<Character> reg = Arrays.asList('-', '_');
        
        StringBuilder sb = new StringBuilder();
        
        Character oldCh = ' ';
        for(int i=0;i<new_id.length();i++) {
        	Character ch = new_id.charAt(i);
        	
        	if(Character.isUpperCase(ch)) {
        		sb.append(Character.toLowerCase(ch));
        	} else if(Character.isDigit(ch) || Character.isLowerCase(ch) || reg.contains(ch)) {
        		sb.append(ch);
        	} else if(ch == 46 && !(oldCh == 46)) {
        		sb.append(ch);
        	} else {
        		continue;
        	}
        	
        	oldCh = ch;        	        	
        }        
        
        
    	if(sb.length() != 0 && sb.charAt(0) == 46) sb.deleteCharAt(0);
        if(sb.length() != 0 &&sb.charAt(sb.length()-1) == 46) sb.deleteCharAt(sb.length()-1);	
        
        
        
        if(sb.length() == 0) sb = new StringBuilder("a");
        
        if(sb.length() >= 16) {        	
        	sb = new StringBuilder(sb.substring(0, 15));        	
        	if(sb.charAt(sb.length()-1) == 46) {
        		sb.deleteCharAt(sb.length()-1);
        	}
        }else if(sb.length() <= 2) {        	
        	while(sb.length() < 3) {
        		sb.append(sb.charAt(sb.length()-1));
        	}
        }
        
        answer = sb.toString();
        
        return answer;
    }
    
    public static void main(String[] args) {
    	String new_id = "...!@BaT#*..y.abcdefghijklm";
    	
    	String answer = solution(new_id);
    	
    	System.out.println(answer);
    }
}
