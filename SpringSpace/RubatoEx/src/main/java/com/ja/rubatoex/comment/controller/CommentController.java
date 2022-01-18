package com.ja.rubatoex.comment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ja.rubatoex.board.service.BoardService;
import com.ja.rubatoex.comment.service.CommentService;
import com.ja.rubatoex.vo.CommentVO;

@Controller
@RequestMapping("/comment/*")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("commentWriteProcess")
	public String commentWriteProcess(
			CommentVO vo,
			String tailParam,
			@RequestParam(value = "page", defaultValue = "1") int page)
	{
		commentService.commentWriteProcess(vo);
		
		return "redirect:../board/boardViewPage?board_no=" + vo.getBoard_no() + "&page=" + page + tailParam;
	}
	
	@RequestMapping("commentDeleteByNoProcess")
	public String commentDeleteByNoProcess(
			int comment_no,
			int board_no,
			String category,
			String keyword,
			@RequestParam(value = "page", defaultValue = "1") int page)
	{
		String tailParam = boardService.makeTailParam(category, keyword);
		commentService.commentDeleteByNoProcess(comment_no);
		
		return "redirect:../board/boardViewPage?board_no=" + board_no + "&page=" + page + tailParam;
	}
	
	@RequestMapping("commentModifyByNoPage")
	public String commentModifyByNoPage(
			int comment_no,
			int board_no,
			String category,
			String keyword,
			@RequestParam(value = "page", defaultValue = "1") int page,			
			HttpSession session) {
		
		String tailParam = boardService.makeTailParam(category, keyword);
		
		session.setAttribute("modifyCommentNo", comment_no);

		return "redirect:../board/boardViewPage?board_no=" + board_no + "&page=" + page + tailParam;
	}
	
	@RequestMapping("commentModifyByNoProcess")
	public String commentModifyByNoProcess(
			CommentVO vo,
			String tailParam,
			@RequestParam(value = "page", defaultValue = "1") int page) 
	{
		commentService.commentModifyByNoProcess(vo);
		
		return "redirect:../board/boardViewPage?board_no=" + vo.getBoard_no() + "&page=" + page + tailParam;
	}
}