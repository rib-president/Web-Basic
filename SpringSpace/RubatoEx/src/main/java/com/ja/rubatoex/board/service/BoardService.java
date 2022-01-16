package com.ja.rubatoex.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.rubatoex.board.mapper.BoardSQLMapper;
import com.ja.rubatoex.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardSQLMapper boardSQLMapper;
	
	public ArrayList<BoardVO> getBoardList() {
		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectAllBoard();
		return resultVOList;
	}
	
	public ArrayList<BoardVO> getBoardByTitle(String title) {
		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectBoardByTitle(title);
		return resultVOList;
	}
	
	public ArrayList<BoardVO> getBoardByContent(String content) {
		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectBoardByContent(content);
		return resultVOList;
	}
	
	public ArrayList<BoardVO> getBoardByWriter(int member_no) {
		ArrayList<BoardVO> resultVOList = boardSQLMapper.selectBoardByWriter(member_no);
		return resultVOList;
	}
	
	public Integer getCountBoard() {
		Integer count = boardSQLMapper.selectCountBoard();
		return count;
	}

	public BoardVO getBoard(int no) {
		BoardVO resultVO = boardSQLMapper.selectBoardByNo(no);
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
		ArrayList<BoardVO> resultVO = boardSQLMapper.select4Board();
		
		return resultVO;
	}
}
