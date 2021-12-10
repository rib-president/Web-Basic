package practice_7.Question02_06;

import java.util.*;

public class Question05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Map<String,String> map = getData();
		Set<String> keySet = map.keySet();
		
		while(true) {
			System.out.println("state를 입력하시오.(none 입력시 종료)");
			String str = input.nextLine();
			if(str.equals("none")) {
				break;
			} else if(keySet.contains(str)) {
				System.out.println(map.get(str));				
			} else {
				System.out.println("해당하는 state가 없습니다.");
			}
		}
		System.out.println("---종료---");
		input.close();
	}
	// 미국 50개 state와 주도(capital)을 map으로 관리하는 메소드
	public static Map<String, String> getData() {
		Map<String, String> map = new HashMap<String, String>();

		String[][] data = {
			{"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
			{"Arkansas", "Little Rock"}, {"California", "Sacramento"},
			{"Colorado", "Denver"}, {"Connecticut", "Hartford"}, 
			{"Delaware", "Dover"}, {"Florida", "Tallahassee"}, 
			{"Georgia", "Atlanta"},{"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
			{"Illinois", "Springfield"}, {"Indiana", "Indianapolis"},
			{"Iowa Des", "Moines"}, {"Kansas", "Topeka"}, {"Kentucky","Frankfort"}, 
			{"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"}, 
			{"Maryland", "Annapolis"}, {"Massachusetts", "Boston"}, 
			{"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"}, 
			{"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"}, 
			{"Montana", "Helena"}, {"Nebraska", "Lincoln"}, 
			{"Nevada	", "Carson City"}, {"New Hampshire", "Concord"}, 
			{"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"}, 
			{"New York", "Albany"}, {"North Carolina", "Raleigh"}, 
			{"North Dakota", "Bismarck"},{"Ohio", "Columbus"},
			{"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"}, 
			{"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"}, 
			{"South Carolina", "Columbia"}, {"South Dakota", "Pierre"}, 
			{"Tennessee", "Nashville"}, {"Texas", "Austin"}, 
			{"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"}, 
			{"Virginia", "Richmond"}, {"Washington", "Olympia"}, 
			{"West Virginia", "Charleston"}, {"Wisconsin", "Madison"}, 
			{"Wyoming", "Cheyenne"}};

		for (int i = 0; i < data.length; i++) {
			map.put(data[i][0], data[i][1]);
		}

		return map;
	}
}
