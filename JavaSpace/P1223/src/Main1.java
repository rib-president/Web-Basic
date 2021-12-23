
public class Main1 {
	public static void main(String[] args) {
		// 특정 숫자의 절대값을 구하시오.
		int a = -10;
		double result = Math.sin(a);
		
		System.out.println(result);
		
		String str = "안녕하세요.반갑습니다.잘부탁드립니다.";
		if(str.equals("dddd")) {
			
		}
		
		str = str.concat("1111");
		
		System.out.println(str);
		
		if(str.contains("반갑")) {
			
		}
		
		str.indexOf('잘');
		str.indexOf("잘부");
		str.indexOf("잘", 0);
		
		int index1 = str.indexOf("잘부");
		System.out.println(index1);
		
		index1 = str.indexOf("qweqwe");
		System.out.println(index1);
		
		index1 = str.lastIndexOf(".");
		System.out.println(index1);
		
		String ttt = str.substring(6);
		System.out.println(ttt);
		
		
		//문제 : 아래와 같이 파일명이 존재할 때(사용자는 알 수 없음) 확장자를 구하세요.
		String fileName = "abcdaowiejfowaiejfowi.faefeawf.eawfawe.jpg";
//		int idx = fileName.lastIndexOf(".");
//		String ext = fileName.substring(idx+1);
//		System.out.println(ext);
		String ext = fileName.substring(fileName.lastIndexOf(".")+1);
		System.out.println(ext);
		
		
		String[] arr = str.split("\\.");
		for(String x : arr) {
			System.out.println(x);
		}
				
		String str2 = "안녕하세요,반갑습니다,잘부탁드립니다,";
		arr = str2.split(",");
		for(String x : arr) {
			System.out.println(x);
		}
		
		String searchWord = " 트와이스    ";
		System.out.println(searchWord);
		searchWord = searchWord.trim();
		System.out.println(searchWord);
		
		String searchWord2 = "tWice";
		String targetWord = "TWICE";
		
		searchWord2 = searchWord2.toLowerCase();
		targetWord = targetWord.toLowerCase();
		
		if(searchWord2.equals(targetWord)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		
		String teettt = str.replaceAll("다", "qwe");
		System.out.println(teettt);
				
	}
}
