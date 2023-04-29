package com.corretto.board.create.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corretto.board.create.mapper.CreateMapper;
import com.corretto.board.vo.ArticleVo;
import com.corretto.board.vo.AttachmentVo;
import com.corretto.board.vo.BoardVo;

@Service
public class CreateService {

	@Autowired
	private CreateMapper createMapper;
	
	public ArrayList<BoardVo> selectBoard() {
		return createMapper.selectBoard();
	}
	
	public int insertArticle(ArticleVo articleVo) {
		createMapper.insertArticle(articleVo);
		return articleVo.getId();
	}
	
	public void insertAttachment(int articleId) {
		for(int i=0;i<3;i++) {
			String location = "./src/main/resources/mockup/" + articleId + "_" + i + ".txt";
			
			createMockup(location);
			
			AttachmentVo attachmentVo = new AttachmentVo();
			attachmentVo.setArticle_id(articleId);
			attachmentVo.setLocation(location);
			
			createMapper.insertAttachment(attachmentVo);
		}
	}
	
	public void createMockup(String location) {

		File file = new File(location);					
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
