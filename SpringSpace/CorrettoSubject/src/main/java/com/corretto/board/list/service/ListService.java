package com.corretto.board.list.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corretto.board.list.mapper.ListMapper;

@Service
public class ListService {
	@Autowired
	private ListMapper listMapper;
	
	public ArrayList<HashMap<String, String>> selectArticleList(String startDateTime, String endDateTime, String boardName) {
		return listMapper.selectArticleList(startDateTime, endDateTime, boardName);
	}
}
