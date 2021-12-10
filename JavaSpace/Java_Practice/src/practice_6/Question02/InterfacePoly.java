package practice_6.Question02;

// 단행본과 부록 CD를 한꺼번에 대출
public class InterfacePoly {
	public static void main(String[] args) {
		Lendable[] arr = {
				new SeperateVolume("1", "푸코의 진자", "움베르토 에코"),
				new SeperateVolume("2", "서양의 미술사", "에른스트 곰브리치"),
				new AppCDInfo("3", "Sprint3.0")
		};
		
		checkOutAll(arr,"김내리", "20140709");
		//checkInAll(arr);
		//toStringAll(arr);
	}
	
	public static void checkOutAll(Lendable[] arr, String borrower, String data) {
		for(Lendable lendable : arr) {
			lendable.checkOut(borrower, data);
		}
	}
	
	public static void checkInAll(Lendable[] arr) {
		for(Lendable lendable : arr) {
			lendable.checkIn();
		}
	}
	
	public static void toStringAll(Lendable[] arr) {
		for(Lendable lendable : arr) {
			System.out.println(lendable.toString());
		}
	}
}
