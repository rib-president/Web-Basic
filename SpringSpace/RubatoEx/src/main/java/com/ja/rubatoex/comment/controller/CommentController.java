package com.ja.rubatoex.comment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.rubatoex.comment.service.CommentService;
import com.ja.rubatoex.vo.CommentVO;

@Controller
@RequestMapping("/comment/*")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("commentWriteProcess")
	public String commentWriteProcess(CommentVO vo) {
		commentService.commentWriteProcess(vo);
		
		return "redirect:../board/boardViewPage?board_no=" + vo.getBoard_no();
	}
	
	@RequestMapping("commentDeleteByNoProcess")
	public String commentDeleteByNoProcess(int comment_no, int board_no) {
		commentService.commentDeleteByNoProcess(comment_no);
		
		return "redirect:../board/boardViewPage?board_no=" + board_no;
	}
	
	@RequestMapping("commentModifyByNoPage")
	public String commentModifyByNoPage(int comment_no, int board_no, HttpSession session) {
		session.setAttribute("modifyCommentNo", comment_no);
		
		return "redirect:../board/boardViewPage?board_no=" + board_no;
	}
	
	@RequestMapping("commentModifyByNoProcess")
	public String commentModifyByNoProcess(CommentVO vo) {
		commentService.commentModifyByNoProcess(vo);
		
		return "redirect:../board/boardViewPage?board_no=" + vo.getBoard_no();
	}
}