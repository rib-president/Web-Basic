package practice_7.Question07.Q15_07;

import java.util.*;

public class BoardDao {
	public List<Board> getBoardList() {
		List<Board> list = new ArrayList<>();
		
		for(int i=1;i<=3;i++) {
			list.add(new Board("제목"+i, "내용"+i));
		}	
		return list;
	}
}
