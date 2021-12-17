package practice_9;

public class Doctors {
	private int doc_seq;
	private int doc_id;
	private String major_treat;
	private String doc_name;
	private char doc_gen;
	private String doc_phone;
	private String doc_email;
	private String doc_position;
	
	public Doctors(int doc_seq) {
		this.doc_seq = doc_seq;
	}

	public int getDoc_seq() {
		return doc_seq;
	}

	public void setDoc_seq(int doc_seq) {
		this.doc_seq = doc_seq;
	}

	public int getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public String getMajor_treat() {
		return major_treat;
	}

	public void setMajor_treat(String major_treat) {
		this.major_treat = major_treat;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public char getDoc_gen() {
		return doc_gen;
	}

	public void setDoc_gen(char doc_gen) {
		this.doc_gen = doc_gen;
	}

	public String getDoc_phone() {
		return doc_phone;
	}

	public void setDoc_phone(String doc_phone) {
		this.doc_phone = doc_phone;
	}

	public String getDoc_email() {
		return doc_email;
	}

	public void setDoc_email(String doc_email) {
		this.doc_email = doc_email;
	}

	public String getDoc_position() {
		return doc_position;
	}

	public void setDoc_position(String doc_position) {
		this.doc_position = doc_position;
	}	
}
