package com.corretto.board.update.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corretto.board.detail.service.DetailService;
import com.corretto.board.update.service.UpdateService;
import com.corretto.board.vo.ArticleVo;

@Controller
public class UpdateController {

	@Autowired
	private UpdateService updateService;
	
	@Autowired
	private DetailService detailService;
	
	@RequestMapping("/updatePage")
	public String updatePage(int articleId, Model model) {
		model.addAttribute("article", detailService.selectArticle(articleId));
		
		return "updatePage";
	}
	
	
	@RequestMapping("/updateArticle")
	public String updateArticle(ArticleVo articleVo) {
		updateService.updateArticle(articleVo);
		
		return "redirect:/detailPage?articleId=" + articleVo.getId();
	}
}
