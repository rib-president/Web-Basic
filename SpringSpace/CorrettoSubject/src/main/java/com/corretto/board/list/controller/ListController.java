package com.corretto.board.list.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corretto.board.list.service.ListService;

@Controller
public class ListController {

	@Autowired
	private ListService listService;
	
	@RequestMapping("/listPage")
	public String listPage(String startDateTime, String endDateTime, String boardName, Model model) {
		
		if(startDateTime != null && startDateTime.isEmpty())		
			startDateTime = null;
		
		if(endDateTime != null && endDateTime.isEmpty())		
			endDateTime = null;

		model.addAttribute("articleMapList", listService.selectArticleList(startDateTime, endDateTime, boardName));		
		
		return "listPage";
	}
}
