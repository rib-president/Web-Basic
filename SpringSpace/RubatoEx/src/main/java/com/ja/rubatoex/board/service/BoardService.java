package com.ja.rubatoex.board.service;

import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.rubatoex.board.mapper.BoardSQLMapper;
import com.ja.rubatoex.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardSQLMapper boardSQLMapper;
	
//	public ArrayList<BoardVO> getBoardList() {
//		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectAllBoard();
//		return titleEscape(resultVOList);
//	}
//	
//	public ArrayList<BoardVO> getBoardByTitle(String title) {
//		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectBoardByTitle(title);
//		
//		return titleEscape(resultVOList);
//	}
//	
//	public ArrayList<BoardVO> getBoardByContent(String content) {
//		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectBoardByContent(content);
//		return titleEscape(resultVOList);
//	}
//	
//	public ArrayList<BoardVO> getBoardByWriter(int member_no) {
//		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectBoardByWriter(member_no);
//		return titleEscape(resultVOList);
//	}
	
	public ArrayList<BoardVO> getBoardList(String category,
			String keyword, int page) {
		return titleEscape(boardSQLMapper.selectBoardList(category, keyword, page));
	}
	
	public int getCountBoard(String category, String keyword) {
		return boardSQLMapper.selectCountBoard(category, keyword);
	}

	public BoardVO getBoard(int no, boolean isEscape) {
		BoardVO resultVO = boardSQLMapper.selectBoardByNo(no);
		
		if(isEscape) {
			titleEscape(resultVO);
			contentEscape(resultVO);
		}
		
		return resultVO;
	}
		
	public void increaseReadCount(int no) {
		boardSQLMapper.updateBoardReadCount(no);
	}
	
	public void deleteBoard(int no) {
		boardSQLMapper.deleteBoard(no);
	}
	
	public void writeBoard(BoardVO vo) {
		boardSQLMapper.insertBoard(vo);
	}
	
	public void modifyBoard(BoardVO vo) {
		boardSQLMapper.updateBoard(vo);
	}
	
	public ArrayList<BoardVO> get4Board() {
		ArrayList<BoardVO> resultVOList = boardSQLMapper.select4Board();

		return titleEscape(resultVOList);
	}
	
	public ArrayList<BoardVO> titleEscape(ArrayList<BoardVO> voList) {
		for(BoardVO vo : voList) {
			vo.setBoard_title(StringEscapeUtils.escapeHtml4(vo.getBoard_title())
					.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;"));
		}
		return voList;
	}
	
	public BoardVO titleEscape(BoardVO vo) {
		vo.setBoard_title(StringEscapeUtils.escapeHtml4(vo.getBoard_title())
		.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;"));

		return vo;
	}
	
	public BoardVO contentEscape(BoardVO vo) {
		vo.setBoard_content(StringEscapeUtils.escapeHtml4(vo.getBoard_content())
		.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;"));

		return vo;
	}
	
	public String makeTailParam(String category, String keyword) {
		String tailParam = "";
		if(category != null) {			
			try {
				tailParam += "&category=" + URLEncoder.encode(category, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(keyword != null) {
			try {
				tailParam += "&keyword=" + URLEncoder.encode(keyword, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		return tailParam;
	}
	
}
