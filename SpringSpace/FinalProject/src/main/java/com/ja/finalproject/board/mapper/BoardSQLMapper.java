package com.ja.finalproject.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ja.finalproject.vo.BoardVO;

public interface BoardSQLMapper {
	// insert, update, delete는 return type void
	public void insertBoard(BoardVO vo);
	
	// 1개의 행을 받을 땐 단일 객체 return, N개의 행을 받을 대는 List로  return 받아야함
	public ArrayList<BoardVO> getBoardList(
			@Param("searchOption") String searchOption, 
			@Param("searchWord") String searchWord,
			@Param("pageNum") int pageNum); 
	
	public int getBoardCount(
			@Param("searchOption") String searchOption, 
			@Param("searchWord") String searchWord
			);
	
	// 게시글 상세 보기
	public BoardVO getBoardByNo(int no);
	
	// 조회수 1 증가시키기
	public void increaseReadCount(int no);
	
	// 글 삭제
	public void deleteBoard(int no);
	
	// 글 수정
	public void updateBoard(BoardVO vo);
}
