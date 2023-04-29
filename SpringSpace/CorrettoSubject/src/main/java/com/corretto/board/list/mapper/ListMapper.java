package com.corretto.board.list.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ListMapper {
	public ArrayList<HashMap<String, String>> selectArticleList(
			@Param("startDateTime") String startDateTime,
			@Param("endDateTime") String endDateTime,
			@Param("boardName") String boardName
			);
}
