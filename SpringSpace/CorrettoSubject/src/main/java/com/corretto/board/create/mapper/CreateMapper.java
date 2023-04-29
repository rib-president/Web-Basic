package com.corretto.board.create.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.corretto.board.vo.ArticleVo;
import com.corretto.board.vo.AttachmentVo;
import com.corretto.board.vo.BoardVo;

@Mapper
public interface CreateMapper {
	public ArrayList<BoardVo> selectBoard();
	public void insertArticle(ArticleVo articleVo);
	public void insertAttachment(AttachmentVo attachmentVo);
}
