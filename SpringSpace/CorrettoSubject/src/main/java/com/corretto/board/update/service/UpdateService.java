package com.corretto.board.update.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corretto.board.update.mapper.UpdateMapper;
import com.corretto.board.vo.ArticleVo;

@Service
public class UpdateService {

	@Autowired
	private UpdateMapper updateMapper;
	
	public void updateArticle(ArticleVo articleVo) {
		updateMapper.updateArticle(articleVo);
	}
}
