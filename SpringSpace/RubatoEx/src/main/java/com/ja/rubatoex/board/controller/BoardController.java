package com.ja.rubatoex.board.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ja.rubatoex.board.service.BoardService;
import com.ja.rubatoex.comment.service.CommentService;
import com.ja.rubatoex.member.service.MemberService;
import com.ja.rubatoex.vo.BoardImageVO;
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
	
	@RequestMapping("boardListPage")
	public String boardListPage(
			String category,
			String keyword,
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model)
	{
		ArrayList<BoardVO> resultVOList = boardService.getBoardList(category, keyword, page);

		int count = boardService.getCountBoard(category, keyword);
		ArrayList<HashMap<String, Object>> resultBoardList = new ArrayList<>();
				
		for(BoardVO boardVO : resultVOList) {

			int member_no = boardVO.getMember_no();
			MemberVO memberVO = memberService.getMemberByNo(member_no);
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("boardVO", boardVO);
			map.put("memberVO", memberVO);
			
			resultBoardList.add(map);
		}
		
		int totalPage = (int) Math.ceil(count / 10.0);
		int startPage = ((page-1)/5) * 5 + 1;
		int endPage = ((page-1)/5 + 1) * 5;
		
		if(endPage > totalPage)
			endPage = totalPage;
				
		model.addAttribute("category", category);
		model.addAttribute("keyword", keyword);
		model.addAttribute("curPage", page);
		model.addAttribute("resultBoardList", resultBoardList);
		model.addAttribute("countBoard", count);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("tailParam", boardService.makeTailParam(category, keyword));
		
		return "board/boardListPage";
	}
	
	
	@RequestMapping("boardViewPage")
	public String boardViewPage(
			int board_no,
			String category,
			String keyword,
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model, HttpSession session)
	{
		ArrayList<CommentVO> commentList = new ArrayList<>();
		if(session.getAttribute("modifyCommentNo") != null) {
			int modifyCommentNo = (Integer) session.getAttribute("modifyCommentNo");
			session.removeAttribute("modifyCommentNo");
			model.addAttribute("modifyCommentNo", modifyCommentNo);
			commentList = commentService.commentGetByNoProcess(board_no, false);
		} else {
			commentList = commentService.commentGetByNoProcess(board_no, true);
		}
		
		HashMap<String, Object> map = new HashMap<>();
		
		boardService.increaseReadCount(board_no);
		BoardVO resultBoardVO = boardService.getBoard(board_no, true);	

		if(resultBoardVO == null) {
			return "board/unavailableAccess";
		}
		
		ArrayList<BoardImageVO> boardImageVOList = boardService.getBoardImage(board_no);
		
		int member_no = resultBoardVO.getMember_no();
		
		MemberVO resultMemberVO = memberService.getMemberByNo(member_no);
		
		map.put("boardVO", resultBoardVO);
		map.put("memberVO", resultMemberVO);

		ArrayList<HashMap<String, Object>> resultCommentList = new ArrayList<>();
		
		for(CommentVO commentVO : commentList) {
			int comment_member_no = commentVO.getMember_no();
			MemberVO memberVO = memberService.getMemberByNo(comment_member_no);
			
			HashMap<String, Object> commentMap = new HashMap<>();
			commentMap.put("commentVO", commentVO);
			commentMap.put("memberVO", memberVO);
			
			resultCommentList.add(commentMap);
		}
		
		model.addAttribute("resultBoard", map);
		model.addAttribute("boardImageVOList", boardImageVOList);
		model.addAttribute("resultComment", resultCommentList);
		model.addAttribute("tailParam", boardService.makeTailParam(category, keyword));
		model.addAttribute("curPage", page);
		
		return "board/boardViewPage";
	}
	
	@RequestMapping("boardDeleteProcess")
	public String boardDeleteProcess(
			int board_no,
			String category,
			String keyword,
			@RequestParam(value = "page", defaultValue = "1") int page,
			HttpSession session) {
		if(session.getAttribute("sessionUser") == null) {
			return "board/denyInvalidAccess";
		}
		
		String tailParam = boardService.makeTailParam(category, keyword);
		
		boardService.deleteBoard(board_no);
		commentService.commentDeleteByBoardNoProcess(board_no);
		
		return "redirect:./boardListPage?page=" + page + tailParam;
	}
	
	@RequestMapping("boardWritePage")
	public String boardWritePage(HttpSession session) {
		if(session.getAttribute("sessionUser") == null) {
			return "board/denyInvalidAccess";
		}
		
		return "board/boardWritePage";
	}
	
	@RequestMapping("boardWriteProcess")
	public String boardWriteProcess(
			BoardVO vo,
			MultipartFile[] uploadFiles,
			HttpSession session ) {

		MemberVO memberVO = (MemberVO) session.getAttribute("sessionUser");
		int member_no = memberVO.getMember_no();
		vo.setMember_no(member_no);
		
		ArrayList<BoardImageVO> boardImageVOList = new ArrayList<>();
		if(uploadFiles != null && !uploadFiles[0].isEmpty()) {			
			boardImageVOList = boardService.setUploadFiles(uploadFiles);
		}
			
		boardService.writeBoard(vo, boardImageVOList);
		
		return "redirect:./boardListPage";
	}
	
	@RequestMapping("boardModifyPage")
	public String boardModifyPage(
			@RequestParam(value = "board_no", defaultValue = "-1") int board_no,
			String category,
			String keyword,
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model,
			HttpSession session) 
	{
		if(session.getAttribute("sessionUser") == null) {
			return "board/denyInvalidAccess";
		}
		
		if(board_no == -1) {
			return "board/unavailableAccess";
		}
		
		BoardVO resultVO = boardService.getBoard(board_no, false);
		ArrayList<BoardImageVO> boardImageVOList = boardService.getBoardImage(board_no);
		
		model.addAttribute("boardVO", resultVO);
		model.addAttribute("boardImageVOList", boardImageVOList);
		model.addAttribute("curPage", page);
		model.addAttribute("tailParam", boardService.makeTailParam(category, keyword));		
		
		return "board/boardModifyPage";
	}
	
	@RequestMapping("boardModifyProcess")
	public String boardModifyProcess(
			BoardVO vo,
			MultipartFile[] uploadFiles,
			int[] del_image_no,
			String tailParam,
			@RequestParam(value = "curPage", defaultValue = "1") int page,
			HttpSession session) {

		if(del_image_no != null) {
			for(int image_no : del_image_no) {
				boardService.deleteBoardImageByNo(image_no);
			}
		}
		
		ArrayList<BoardImageVO> boardImageVOList = new ArrayList<>();
		if(uploadFiles != null && !uploadFiles[0].isEmpty()) {			
			boardImageVOList = boardService.setUploadFiles(uploadFiles);
		}		
		
		boardService.modifyBoard(vo, boardImageVOList);
		
		return "redirect:./boardViewPage?board_no=" + vo.getBoard_no() + "&page=" + page + tailParam;
	}
}
