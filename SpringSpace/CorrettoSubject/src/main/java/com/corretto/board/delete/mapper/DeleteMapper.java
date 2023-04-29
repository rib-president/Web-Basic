package com.corretto.board.delete.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteMapper {
	public void deleteArticle(int id);
	public void deleteAttachment(int article_id);
}
