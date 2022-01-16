package com.ja.rubatoex.comment.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.rubatoex.comment.mapper.CommentSQLMapper;
import com.ja.rubatoex.vo.CommentVO;

@Service
public class CommentService {
	@Autowired
	private CommentSQLMapper commentSQLMapper;
	
	public void commentWriteProcess(CommentVO vo) {
		commentSQLMapper.insertComment(vo);
	}
	
	public ArrayList<CommentVO> commentGetByNoProcess(int no) {
		ArrayList<CommentVO> resultCommentVO = commentSQLMapper.selectCommentByNo(no);
		
		return resultCommentVO;
	}
	
	public void commentDeleteByNoProcess(int no) {
		commentSQLMapper.deleteCommentByNo(no);
	}
	
	public void commentDeleteByBoardNoProcess(int board_no) {
		commentSQLMapper.deleteCommentByBoardNo(board_no);
	}
	
	public void commentModifyByNoProcess(CommentVO vo) {
		commentSQLMapper.updateCommentByNo(vo);
	}
}
