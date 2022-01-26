package com.lotto.shinnanda.board.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.lotto.shinnanda.vo.BoardImageVo;
import com.lotto.shinnanda.vo.BoardVo;
import com.lotto.shinnanda.vo.CommentVo;

public interface BoardSQLMapper {
	// board_no PK 생성
	public int createBoardNo();
	
	// insert
	public void insertBoard(BoardVo vo);
	public void insertBoardImage(BoardImageVo vo);
	
	// select
	public Map<String, Object> selectBoardByNo(int board_no);
	public void increaseReadCountByNo(int no);
	public int selectBoardReadCount(int no);
	public ArrayList<BoardImageVo> selectBoardImageByBoardNo(int board_no);
	public ArrayList<BoardVo> selectBoardList(
			@Param("pageNum") int pageNum,
			@Param("searchOption") String searchOption,
			@Param("searchWord") String searchWord);
	public BoardImageVo selectBoardImageThumbnailByBoardNo(int board_no);
	public int selectTotalBoardCount(
			@Param("searchOption") String searchOption,
			@Param("searchWord") String searchWord);
	
	// update
	public void updateBoard(BoardVo vo);
	
	// delete
	public void deleteBoardByNo(int no);
	public void deleteBoardImageByNo(int no);
	public void deleteBoardImaegeByBoardNo(int board_no);
	
	public void insertComment(CommentVo vo);
	public ArrayList<HashMap<String, Object>> selectCommentByBoardNo(int board_no);
	public void updateComment(CommentVo vo);
	public void deleteCommentByNo(int no);
	public void deleteCommentByBoardNo(int board_no);
}
