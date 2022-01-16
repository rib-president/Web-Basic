package com.ja.rubatoex.comment.mapper;

import java.util.ArrayList;

import com.ja.rubatoex.vo.CommentVO;

public interface CommentSQLMapper {
	public void insertComment(CommentVO vo);
	public ArrayList<CommentVO> selectCommentByNo(int no);
	public void deleteCommentByNo(int no);
	public void deleteCommentByBoardNo(int board_no);
	public void updateCommentByNo(CommentVO vo);
}
