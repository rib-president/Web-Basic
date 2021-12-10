package p01.basic3;

public class Book {
	String title;
	String author;
	
	public Book(String t) {
		title = t;
		author = "작가미상";
	}
	
	public Book(String t, String a) {
		title = t;
		author = a;
	}
	
	public void printBookInformation() {
		System.out.println("책 제목 = " + title + ", 저자 = " + author);
	}
}
