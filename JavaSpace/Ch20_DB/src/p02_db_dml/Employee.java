package p02_db_dml;

public class Employee {
	private int emplid;
	private String name;
	private String password;
	private String emailaddr;
	private String socialno;
	private String dept;
	private String adminyn;
	
	
	public Employee() {
		
	}
	
	public Employee(int emplid, String name, String password, String emailaddr, String socialno, String dept,
			String adminyn) {
		this.emplid = emplid;
		this.name = name;
		this.password = password;
		this.emailaddr = emailaddr;
		this.socialno = socialno;
		this.dept = dept;
		this.adminyn = adminyn;
	}

	public int getEmplid() {
		return emplid;
	}

	public void setEmplid (int emplid) {
		this.emplid = emplid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailaddr() {
		return emailaddr;
	}

	public void setEmailaddr(String emailaddr) {
		this.emailaddr = emailaddr;
	}

	public String getSocialno() {
		return socialno;
	}

	public void setSocialno(String socialno) {
		this.socialno = socialno;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAdminyn() {
		return adminyn;
	}

	public void setAdminyn(String adminyn) {
		this.adminyn = adminyn;
	}

}
