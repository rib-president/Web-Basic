package p01.basic;

//	면적(Area) 계산하기(compute) => comment
public class ComputeArea {

	public static void main(String[] args) {
		double radius;	// radius 변수 이름을 갖는 데이터 저장소 정의
		double area;	// area 변수 이름을 갖는 데이터 저장소 정의
		
		// 1. 반지름 읽기
		radius = 30;
		
		// 2. 원의 면적 계산하기 : 입력 데이터를 출력 데이터로 가공
		area = radius * radius * 3.14159;
		
		// 3. 원의 면적을 console창에 보여주기
		System.out.println("원의 반지름이 " + radius + "인 "
								+ "원의 면적은 " + area + " 입니다.");
		
		
	}

}
