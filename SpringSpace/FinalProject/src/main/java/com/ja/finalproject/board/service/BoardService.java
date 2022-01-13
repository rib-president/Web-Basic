package com.ja.finalproject.board.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.board.mapper.BoardSQLMapper;
import com.ja.finalproject.member.mapper.MemberSQLMapper;
import com.ja.finalproject.vo.BoardVO;
import com.ja.finalproject.vo.MemberVO;

@Service
public class BoardService {
	@Autowired
	private BoardSQLMapper boardSQLMapper;
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void writeContent(BoardVO vo) {
		// 실제는 유효성 검사해야하는 부분(제목에 욕 같은거)
		boardSQLMapper.insertBoard(vo);
	}
	
	public ArrayList<HashMap<String, Object>> getBoardList() {
		ArrayList<BoardVO> boardVOList = boardSQLMapper.getBoardList();
		
		ArrayList<HashMap<String, Object>> dataList = new ArrayList<>();
		
		for(BoardVO boardVO : boardVOList) {
			int memberNo = boardVO.getMember_no();	// 작성자 번호
			
			// SELECT * FROM FP_Member WHERE member_no = #{no}
			MemberVO memberVO = memberSQLMapper.getMemberByNo(memberNo);
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("memberVO", memberVO);
			map.put("boardVO", boardVO);
			
			dataList.add(map);
		}
		return dataList;
	}
	
	public HashMap<String, Object> getBoard(int board_no) {
		HashMap<String, Object> map = new HashMap<>();
		
		BoardVO boardVO = boardSQLMapper.getBoardByNo(board_no);
		
		int memberNo = boardVO.getMember_no();
		MemberVO memberVO = memberSQLMapper.getMemberByNo(memberNo);
		
		map.put("memberVO", memberVO);
		map.put("boardVO", boardVO);
		
		return map;
	}
}
