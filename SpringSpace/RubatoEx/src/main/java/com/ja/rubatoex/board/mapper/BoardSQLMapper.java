package com.ja.rubatoex.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ja.rubatoex.vo.BoardImageVO;
import com.ja.rubatoex.vo.BoardVO;

public interface BoardSQLMapper {
	public BoardVO selectBoardByNo(int no);
	public ArrayList<BoardImageVO> selectBoardImageByBoardNo(int board_no);

	public ArrayList<BoardVO> selectBoardList(
			@Param("category") String category,
			@Param("keyword") String keyword,
			@Param("page") int page);
	public void updateBoardReadCount(int no);
	
	public void deleteBoard(int no);
	public void deleteBoardImage(int board_no);
	public void deleteBoardImageByNo(int no);
	
	public int createBoardPK();
	public void insertBoard(BoardVO vo);
	public void insertBoardImage(BoardImageVO vo);
	
	public void updateBoard(BoardVO vo);
	public int selectCountBoard(
			@Param("category") String category,
			@Param("keyword") String keyword);
	public ArrayList<BoardVO> select4Board();
}
