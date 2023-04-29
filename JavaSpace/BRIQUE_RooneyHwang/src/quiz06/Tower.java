package quiz06;

import java.util.*;
import java.util.stream.Collectors;

public class Tower {
	
	private List<String> towerArr;
	
	public Tower(String towerStr) {
		this.towerArr = Arrays.asList(towerStr.split(" ")).stream().collect(Collectors.toList());
	}
	
	public void getResult() {
		
		int length = towerArr.size();
		ArrayList<Integer> resultList = new ArrayList<>();
		
		outer : for(int i=length-1;i>=0;i--) {
			try {
				int target = Integer.valueOf(towerArr.get(i));
				towerArr.remove(i);
				
				for(int j=towerArr.size()-1;j>=0;j--) {
					if(target < Integer.valueOf(towerArr.get(j))) {
						resultList.add(0, j+1);
						continue outer;
					}
				}
				resultList.add(0, 0);	
			} catch(Exception e) {
				System.out.println("NumberFomratException ] " + e.getMessage());
				return;
			}
			
		}
		
		System.out.print("result: ");
		for(int result : resultList) {
			System.out.print(result + " ");
		}
	}
}
