package com.corretto.board.detail.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corretto.board.detail.service.DetailService;
import com.corretto.board.vo.ArticleVo;

@Controller
public class DetailController {

	@Autowired
	private DetailService detailService;
	
	@RequestMapping("/detailPage")
	public String detailPage(int articleId, Model model) {

		detailService.updateArticleViewCount(articleId);
		ArticleVo articleVo = detailService.selectArticle(articleId);		
		
		model.addAttribute("article", articleVo);
		model.addAttribute("boardName", detailService.selectBoardName(articleVo.getBoard_id()));
		model.addAttribute("attachmentList", detailService.selectAttachment(articleId));
		
		return "detailPage";
	}
}
