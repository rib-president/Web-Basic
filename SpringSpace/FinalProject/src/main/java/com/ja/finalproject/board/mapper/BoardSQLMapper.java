package com.ja.finalproject.board.mapper;

import java.util.ArrayList;

import com.ja.finalproject.vo.BoardVO;

public interface BoardSQLMapper {
	// insert, update, delete는 return type void
	public void insertBoard(BoardVO vo);
	
	// 1개의 행을 받을 땐 단일 객체 return, N개의 행을 받을 대는 List로  return 받아야함
	public ArrayList<BoardVO> getBoardList(); 
	
	public BoardVO getBoardByNo(int no);
}
