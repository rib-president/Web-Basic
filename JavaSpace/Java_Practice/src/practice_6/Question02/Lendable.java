package practice_6.Question02;

public interface Lendable {
	// 대출한다
	void checkOut(String borrower, String date);
	
	// 반납한다
	void checkIn();
}
