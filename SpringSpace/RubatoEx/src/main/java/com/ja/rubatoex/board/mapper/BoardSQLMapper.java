package com.ja.rubatoex.board.mapper;

import java.util.ArrayList;

import com.ja.rubatoex.vo.BoardVO;

public interface BoardSQLMapper {
	public ArrayList<BoardVO> selectAllBoard();
	public BoardVO selectBoardByNo(int no);
	public ArrayList<BoardVO> selectBoardByTitle(String title);
	public ArrayList<BoardVO> selectBoardByContent(String content);
	public ArrayList<BoardVO> selectBoardByWriter(int member_no);
	public void updateBoardReadCount(int no);
	public void deleteBoard(int no);
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public Integer selectCountBoard();
	public ArrayList<BoardVO> select4Board();
}
