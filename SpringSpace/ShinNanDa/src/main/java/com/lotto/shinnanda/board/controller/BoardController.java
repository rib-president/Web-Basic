package com.lotto.shinnanda.board.controller;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lotto.shinnanda.board.service.BoardService;
import com.lotto.shinnanda.commons.MultipartFileUtil;
import com.lotto.shinnanda.commons.StringUtil;
import com.lotto.shinnanda.vo.BoardImageVo;
import com.lotto.shinnanda.vo.BoardVo;
import com.lotto.shinnanda.vo.CommentVo;
import com.lotto.shinnanda.vo.MemberVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("mainPageRN")
	public String mainPage(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, 
			String searchOption, String searchWord, Model model) {
		
		System.out.println("시스템 로그] 메인 페이지 실행");
		
		ArrayList<HashMap<String, Object>> resultList = 
				boardService.getBoardList(pageNum, searchOption, searchWord);
		
		int totalPageCount = (int) Math.ceil(boardService.getTotalBoardCount(searchOption, searchWord) / 6.0);	
		
		int startPage = ((pageNum-1)/5)*5 + 1;
		int endPage = ((pageNum-1)/5 + 1) * (5);
		
		if(endPage >= totalPageCount) {
			endPage = totalPageCount;
		}

		model.addAttribute("boardList", resultList);
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("tailParam", StringUtil.tailParam(searchOption, searchWord));
		
		return "board/mainPageRN";
	}
	
	@RequestMapping("readContentPage")
	public String readContentPage(int board_no,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, 
			String searchOption, String searchWord,
			Model model, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> resultMap = boardService.getBoard(board_no, true);		
		ArrayList<BoardImageVo> boardImageVo = boardService.getBoardImage(board_no);
		
		// 조회수 증가
		int cookieFlag = 0;
		String str_board_no = "/" + String.valueOf(board_no) + "/";
		
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			String cookieName = cookie.getName();

			if(cookieName.equals("readBoardNo")) {
				cookieFlag++;
				String cookieValue = cookie.getValue();
				if(cookieValue.indexOf(str_board_no) == -1) {
					Cookie newCookie = new Cookie("readBoardNo", cookieValue + str_board_no);
					response.addCookie(newCookie);
					boardService.increaseReadCount(board_no);
				}
			}
		}
		
		if(cookieFlag == 0) {
			Cookie newCookie = new Cookie("readBoardNo",str_board_no);
			response.addCookie(newCookie);
			boardService.increaseReadCount(board_no);
		}
		
		ArrayList<HashMap<String, Object>> resultCommentMapList = boardService.getCommentList(board_no);
		
		model.addAttribute("resultMap", resultMap);
		model.addAttribute("resultCommentMapList", resultCommentMapList);
		model.addAttribute("boardImageVo", boardImageVo);
		model.addAttribute("readCount", boardService.getBoardReadCount(board_no));
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("tailParam", StringUtil.tailParam(searchOption, searchWord));
		
		return "board/readContentPage";
	}
	
	@RequestMapping("writeContentPage")
	public String writeContentPage() {
		return "board/writeContentPage";
	}
	
	@RequestMapping("writeContentProcess")
	public String writeContentProcess(BoardVo boardVo, MultipartFile[] uploadFiles, HttpSession session) {

		MemberVo sessionUser = (MemberVo) session.getAttribute("sessionUser");
		boardVo.setMember_no(sessionUser.getMember_no());

		ArrayList<BoardImageVo> boardImageVoList = MultipartFileUtil.transferToUploadFolder(uploadFiles);
		
		int board_no = boardService.writeBoard(boardVo, boardImageVoList);
		
		return "redirect:./readContentPage?board_no=" + board_no;
	}
	
	@RequestMapping("deleteContentProcess")
	public String deleteContentProcess(int board_no, 
			@RequestParam(value="pageNum", defaultValue="1") int pageNum, String tailParam) {
		
		boardService.delBoardByNo(board_no);
		boardService.delBoardImageByBoardNo(board_no);
		boardService.delCommentByBoardNo(board_no);
		
		if(tailParam == null) {
			tailParam = "";
		}
		
		return "redirect:../board/mainPageRN?pageNum=" + pageNum + tailParam;
	}
	
	@RequestMapping("modifyContentPage")
	public String modifyContentPage(int board_no,
			@RequestParam(value="pageNum", defaultValue="1") int pageNum, String tailParam, Model model) {
		
		Map<String, Object> resultMap = boardService.getBoard(board_no, false);
		ArrayList<BoardImageVo> boardImageVoList = boardService.getBoardImage(board_no);
		
		model.addAttribute("resultMap", resultMap);
		model.addAttribute("boardImageVoList", boardImageVoList);
		model.addAttribute("board_no", board_no);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("tailParam", tailParam);
		
		return "board/modifyContentPage";
	}
	
	@RequestMapping("modifyContentProcess")
	public String modifyContentProcess(BoardVo boardVo, MultipartFile[] uploadFiles, int[] del_image_nos,
			int pageNum, String tailParam) {
		
		boardService.modifyBoard(boardVo);
		
		if(del_image_nos != null) {
			for(int del_image_no : del_image_nos) {
				boardService.delBoardImageByNo(del_image_no);
			}
		}
		ArrayList<BoardImageVo> boardImageVoList = MultipartFileUtil.transferToUploadFolder(uploadFiles);
		boardService.addBoardImage(boardImageVoList, boardVo.getBoard_no());
		
		return "redirect:../board/readContentPage?board_no=" + boardVo.getBoard_no() + "&pageNum=" + pageNum + tailParam;
	}
	
	@RequestMapping("writeCommentProcess")
	public String writeCommentProcess(CommentVo vo, int pageNum, String tailParam) {
		boardService.writeComment(vo);
		
		return "redirect:../board/readContentPage?board_no=" + vo.getBoard_no() + "&pageNum=" + pageNum + tailParam;
	}
	
	@RequestMapping("deleteCommentProcess")
	public String deleteCommentProcess(int comment_no, int board_no, int pageNum, String tailParam) {
		boardService.delCommentByNo(comment_no);
		
		if(tailParam == null) {
			tailParam = "";
		}
		return "redirect:../board/readContentPage?board_no=" + board_no + "&pageNum=" + pageNum + tailParam;
	}
	
	@RequestMapping("modifyCommentProcess")
	public String modifyCommentProcess(CommentVo vo, int board_no, int pageNum, String tailParam) {
		boardService.modifyComment(vo);
		
		if(tailParam.equals("undefined")) {
			tailParam = "";
		}
		
		return "redirect:../board/readContentPage?board_no=" + board_no + "&pageNum=" + pageNum + tailParam;
	}
}
