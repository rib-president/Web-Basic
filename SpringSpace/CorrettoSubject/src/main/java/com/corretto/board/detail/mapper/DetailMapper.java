package com.corretto.board.detail.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.corretto.board.vo.ArticleVo;
import com.corretto.board.vo.AttachmentVo;

@Mapper
public interface DetailMapper {
	public ArticleVo selectArticle(int id);
	public void updateArticleViewCount(int id);
	public String selectBoardName(int board_id);
	public ArrayList<AttachmentVo> selectAttachment(int article_id);
}
