package com.lotto.shinnanda.board.controller;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lotto.shinnanda.board.service.BoardService;
import com.lotto.shinnanda.commons.StringUtil;
import com.lotto.shinnanda.vo.BoardImageVo;

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
		Map<String, Object> resultVo = boardService.getBoard(board_no, true);		
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
		
		model.addAttribute("resultVo", resultVo);
		model.addAttribute("boardImageVo", boardImageVo);
		model.addAttribute("readCount", boardService.getBoardReadCount(board_no));
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("tailParam", StringUtil.tailParam(searchOption, searchWord));
		
		return "board/readContentPage";
	}
}
