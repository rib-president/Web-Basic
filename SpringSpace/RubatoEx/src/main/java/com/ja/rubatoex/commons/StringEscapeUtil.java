package com.ja.rubatoex.commons;

import java.util.ArrayList;

import org.apache.commons.text.StringEscapeUtils;

import com.ja.rubatoex.vo.BoardVO;

public class StringEscapeUtil {
	public static ArrayList<BoardVO> titleEscape(ArrayList<BoardVO> voList) {
		for(BoardVO vo : voList) {
			vo.setBoard_title(StringEscapeUtils.escapeHtml4(vo.getBoard_title())
					.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;"));
		}
		return voList;
	}
	
	public static BoardVO titleEscape(BoardVO vo) {
		vo.setBoard_title(StringEscapeUtils.escapeHtml4(vo.getBoard_title())
		.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;"));

		return vo;
	}
	
	public static BoardVO contentEscape(BoardVO vo) {
		vo.setBoard_content(StringEscapeUtils.escapeHtml4(vo.getBoard_content())
		.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;"));

		return vo;
	}
}
