package p01.basic;

//	배열 원소의 type이 char인 경우
//	char[] 배열인 경우 변수 출력하면 string(문자열)로 출력됨
public class ArrayBasic5 {
	public static void main(String[] args) {
		char[] city = {'D', 'a', 'l', 'l', 'a', 's'};
		
		for(char element : city) {
			System.out.println(element);
		}
		
		System.out.println(city);
		
	}
}
