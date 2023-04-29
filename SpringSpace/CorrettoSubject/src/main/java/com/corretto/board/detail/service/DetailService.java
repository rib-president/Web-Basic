package com.corretto.board.detail.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corretto.board.detail.mapper.DetailMapper;
import com.corretto.board.vo.ArticleVo;
import com.corretto.board.vo.AttachmentVo;

@Service
public class DetailService {
	@Autowired
	private DetailMapper detailMapper;
	
	public void updateArticleViewCount(int id) {
		detailMapper.updateArticleViewCount(id);
	}
	
	public ArticleVo selectArticle(int id) {
		return detailMapper.selectArticle(id);
	}
	
	public String selectBoardName(int board_id) {
		return detailMapper.selectBoardName(board_id);
	}
	
	public ArrayList<AttachmentVo> selectAttachment(int article_id) {
		return detailMapper.selectAttachment(article_id);
	}
}
