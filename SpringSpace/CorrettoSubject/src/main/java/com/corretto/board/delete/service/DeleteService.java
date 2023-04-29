package com.corretto.board.delete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corretto.board.delete.mapper.DeleteMapper;

@Service
public class DeleteService {

	@Autowired
	private DeleteMapper deleteMapper;
	
	public void deleteArticle(int id) {
		deleteMapper.deleteArticle(id);
	}
	
	public void deleteAttachment(int article_id) {
		deleteMapper.deleteAttachment(article_id);
	}
	
}
