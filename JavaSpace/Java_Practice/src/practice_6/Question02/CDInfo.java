package practice_6.Question02;

public class CDInfo {
	String registerNo;	// 관련번호
	String title;		// 타이틀
	
	CDInfo(String registerNo, String title) {
		this.registerNo = registerNo;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "관련번호 : " + registerNo + ", 타이틀 : " + title;
	}
}
