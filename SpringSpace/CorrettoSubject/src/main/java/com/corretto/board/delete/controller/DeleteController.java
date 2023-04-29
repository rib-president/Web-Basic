package com.corretto.board.delete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corretto.board.delete.service.DeleteService;

@Controller
public class DeleteController {

	@Autowired
	private DeleteService deleteService;
	
	@RequestMapping("/deleteArticle")
	public String deleteArticle(int articleId) {
		deleteService.deleteAttachment(articleId);
		deleteService.deleteArticle(articleId);		
		
		return "redirect:/listPage";
	}
	
}
