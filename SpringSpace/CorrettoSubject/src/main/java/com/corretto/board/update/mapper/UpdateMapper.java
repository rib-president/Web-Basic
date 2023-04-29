package com.corretto.board.update.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.corretto.board.vo.ArticleVo;

@Mapper
public interface UpdateMapper {
	public void updateArticle(ArticleVo articleVo);
}
