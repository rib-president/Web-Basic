package com.corretto.board.create.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corretto.board.create.service.CreateService;
import com.corretto.board.vo.ArticleVo;
import com.corretto.board.vo.BoardVo;

@Controller
public class CreateController {

	@Autowired
	private CreateService createService;
	
	@RequestMapping("/createPage")
	public String createPage(Model model) {
		model.addAttribute("boardCategory", createService.selectBoard());
		
		return "createPage";
	}
	
	@RequestMapping("/insertArticle")
	public String insertArticle(ArticleVo articleVo) {
		
		int articleId = createService.insertArticle(articleVo);		
		createService.insertAttachment(articleId);
		
		return "redirect:/detailPage?articleId=" + articleId;
	}
}
