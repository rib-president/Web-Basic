package com.ja.rubatoex.board.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.rubatoex.board.service.BoardService;
import com.ja.rubatoex.comment.service.CommentService;
import com.ja.rubatoex.member.service.MemberService;
import com.ja.rubatoex.vo.BoardVO;
import com.ja.rubatoex.vo.CommentVO;
import com.ja.rubatoex.vo.MemberVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CommentService commentService;
	
//	@RequestMapping("boardListPage")
//	public String boardListPage(Model model) {
//		ArrayList<BoardVO> boardList = boardService.getBoardList();
//		Integer count = boardService.getCountBoard();
//		ArrayList<HashMap<String, Object>> resultBoardList = new ArrayList<>();
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		
//		for(BoardVO boardVO : boardList) {
//			Date board_writedate = boardVO.getBoard_writedate();
//
//			int member_no = boardVO.getMember_no();
//			MemberVO memberVO = memberService.getMemberByNo(member_no);
//			
//			HashMap<String, Object> map = new HashMap<>();
//			map.put("boardVO", boardVO);
//			map.put("memberVO", memberVO);
//			map.put("writedate", sdf.format(board_writedate));
//			
//			resultBoardList.add(map);
//		}
//		
//		model.addAttribute("resultBoardList", resultBoardList);
//		model.addAttribute("countBoard", count);
//		
//		return "board/boardListPage";
//	}
	
	@RequestMapping("boardListPage")
	public String boardListPage(String category, String keyword, Model model) {
		ArrayList<BoardVO> resultVOList = new ArrayList<>();
		if(category != null) {
			if(category.equals("title")) {
				resultVOList = boardService.getBoardByTitle(keyword);
			} else if(category.equals("content")) {
				resultVOList = boardService.getBoardByContent(keyword);			
			} else if(category.equals("writer")) {
				ArrayList<MemberVO> resultMemberVOList = memberService.getMemberByNick(keyword);
				resultVOList = new ArrayList<>();
				
				for(MemberVO memberVO : resultMemberVOList) {
					int search_member_no = memberVO.getMember_no();
					ArrayList<BoardVO> boardVOList = boardService.getBoardByWriter(search_member_no);
					resultVOList.addAll(boardVOList);
				}
		
				resultVOList = (ArrayList<BoardVO>) resultVOList.stream().
								sorted((a, b) -> Integer.compare(b.getBoard_no(), a.getBoard_no())).
								collect(Collectors.toList());
			}
			model.addAttribute("category", category);
			model.addAttribute("keyword", keyword);
		} else if(category == null && keyword == null) {
			resultVOList = boardService.getBoardList();
		}
		
		Integer count = resultVOList.size();
		//Integer count = boardService.getCountBoard();
		ArrayList<HashMap<String, Object>> resultBoardList = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for(BoardVO boardVO : resultVOList) {
			Date board_writedate = boardVO.getBoard_writedate();

			int member_no = boardVO.getMember_no();
			MemberVO memberVO = memberService.getMemberByNo(member_no);
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("boardVO", boardVO);
			map.put("memberVO", memberVO);
			map.put("writedate", sdf.format(board_writedate));
			
			resultBoardList.add(map);
		}
		
		model.addAttribute("resultBoardList", resultBoardList);
		model.addAttribute("countBoard", count);
		
		return "board/boardListPage";
	}
	
	
	
	@RequestMapping("boardViewPage")
	public String boardViewPage(int board_no, String category, String keyword, Model model, HttpSession session) {
		if(session.getAttribute("modifyCommentNo") != null) {
			int modifyCommentNo = (Integer) session.getAttribute("modifyCommentNo");
			session.removeAttribute("modifyCommentNo");
			model.addAttribute("modifyCommentNo", modifyCommentNo);
		}
		
		HashMap<String, Object> map = new HashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (HH:mm)");
		
		boardService.increaseReadCount(board_no);
		BoardVO resultBoardVO = boardService.getBoard(board_no);
		Date board_writedate = null;
		
		try {
			board_writedate = resultBoardVO.getBoard_writedate();
		} catch(NullPointerException e) {
			return "board/unavailableAccess";
		}
		
		int member_no = resultBoardVO.getMember_no();
		
		MemberVO resultMemberVO = memberService.getMemberByNo(member_no);
		
		map.put("boardVO", resultBoardVO);
		map.put("memberVO", resultMemberVO);
		map.put("writedate", sdf.format(board_writedate));
		
		ArrayList<CommentVO> commentList = commentService.commentGetByNoProcess(board_no);
		ArrayList<HashMap<String, Object>> resultCommentList = new ArrayList<>();
		SimpleDateFormat sdfComment = new SimpleDateFormat("yy-MM-dd");
		
		for(CommentVO commentVO : commentList) {
			int comment_member_no = commentVO.getMember_no();
			MemberVO memberVO = memberService.getMemberByNo(comment_member_no);
			
			Date comment_writedate = commentVO.getComment_writedate();
			
			HashMap<String, Object> commentMap = new HashMap<>();
			commentMap.put("commentVO", commentVO);
			commentMap.put("memberVO", memberVO);
			commentMap.put("writedate", sdfComment.format(comment_writedate));
			
			resultCommentList.add(commentMap);
		}
		
		model.addAttribute("resultBoard", map);
		model.addAttribute("resultComment", resultCommentList);
		if(category != null) {
			model.addAttribute("category", category);
			model.addAttribute("keyword", keyword);
		}
		
		return "board/boardViewPage";
	}
	
	@RequestMapping("boardDeleteProcess")
	public String boardDeleteProcess(int board_no, HttpSession session) {
		if(session.getAttribute("sessionUser") == null) {
			return "board/denyInvalidAccess";
		}
		
		boardService.deleteBoard(board_no);
		commentService.commentDeleteByBoardNoProcess(board_no);
		
		return "redirect:./boardListPage";
	}
	
	@RequestMapping("boardWritePage")
	public String boardWritePage(HttpSession session) {
		if(session.getAttribute("sessionUser") == null) {
			return "board/denyInvalidAccess";
		}
		
		return "board/boardWritePage";
	}
	
	@RequestMapping("boardWriteProcess")
	public String boardWriteProcess(BoardVO vo, HttpSession session ) {

		MemberVO memberVO = (MemberVO) session.getAttribute("sessionUser");
		int member_no = memberVO.getMember_no();
		
		vo.setMember_no(member_no);
		
		boardService.writeBoard(vo);
		
		return "redirect:./boardListPage";
	}
	
	@RequestMapping("boardModifyPage")
	public String boardModifyPage(Integer board_no, Model model, HttpSession session) {
		if(session.getAttribute("sessionUser") == null) {
			return "board/denyInvalidAccess";
		}
		
		BoardVO resultVO = boardService.getBoard(board_no);
		
		model.addAttribute("boardVO", resultVO);
		
		return "board/boardModifyPage";
	}
	
	@RequestMapping("boardModifyProcess")
	public String boardModifyProcess(BoardVO vo, HttpSession session) {

		boardService.modifyBoard(vo);
		
		return "redirect:./boardListPage";
	}
}
