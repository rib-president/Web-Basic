package p02.datatypes.promotion;

public class PromotionEx2 {

	public static void main(String[] args) {
		int baseInterestRate = 3;	// 이자율 3%
		
		//	4 bytes => 8 bytes 변경되어 newInterestRate에 값이 들어감
		// (자동형변환, promotion)
		long newInterestRate = baseInterestRate;
		
		//	long type 8bytes => 4bytes float type 변경 가능
		//	(자동형변환, promotion)
		//	long의 최대값 < float의 최대값 => 자동형변환 허용
		float japanInterestRate = newInterestRate;
		
		System.out.println("baseInterestRate = " + baseInterestRate);
		System.out.println("newInterestRate = " + newInterestRate);
		System.out.println("japanInterestRate = " + japanInterestRate);

	}

}
