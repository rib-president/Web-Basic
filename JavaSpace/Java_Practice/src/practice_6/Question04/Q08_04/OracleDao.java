package practice_6.Question04.Q08_04;

public class OracleDao implements DataAccessObject {
	String dbName = "Oracle DB";
		
	@Override
	public void select() {
		System.out.println(dbName + "에서 검색");
	}

	@Override
	public void insert() {
		System.out.println(dbName + "에 삽입");
	}

	@Override
	public void update() {
		System.out.println(dbName + "를 수정");
	}

	@Override
	public void delete() {
		System.out.println(dbName + "에서 삭제");
	}
}
