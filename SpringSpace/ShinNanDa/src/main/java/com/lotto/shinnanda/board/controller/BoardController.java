package com.lotto.shinnanda.board.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lotto.shinnanda.board.service.BoardService;
import com.lotto.shinnanda.commons.StringUtil;

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
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("tailParam", StringUtil.tailParam(searchOption, searchWord));
		
		return "board/mainPageRN";
	}
}
