package com.ja.rubatoex.main.controller;

//import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.rubatoex.board.service.BoardService;
import com.ja.rubatoex.vo.BoardVO;

@Controller
@RequestMapping("/main/*")
public class MainController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("main")
	public String main(Model model) {
		ArrayList<BoardVO> voList = boardService.get4Board();
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<>();
		
		for(BoardVO vo : voList) {
			HashMap<String, Object> map = new HashMap<>();
			
			map.put("boardVO", vo);
			
			resultList.add(map);
		}
		model.addAttribute("resultList", resultList);
		return "main/main";
	}
}
