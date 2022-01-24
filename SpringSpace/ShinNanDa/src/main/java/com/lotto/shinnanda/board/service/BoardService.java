package com.lotto.shinnanda.board.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lotto.shinnanda.board.mapper.BoardSQLMapper;
import com.lotto.shinnanda.commons.StringUtil;
import com.lotto.shinnanda.member.mapper.MemberSQLMapper;
import com.lotto.shinnanda.vo.BoardImageVo;
import com.lotto.shinnanda.vo.BoardVo;
import com.lotto.shinnanda.vo.MemberVo;

@Service
public class BoardService {
	@Autowired
	private BoardSQLMapper boardSQLMapper;
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void writeBoard(BoardVo boardVo, ArrayList<BoardImageVo> boardImageVoList) {
		int board_no = boardSQLMapper.createBoardNo();
		
		boardVo.setBoard_no(board_no);
		boardSQLMapper.insertBoard(boardVo);
		
		for(BoardImageVo boardImageVo : boardImageVoList) {
			boardImageVo.setBoard_no(board_no);
			boardSQLMapper.insertBoardImage(boardImageVo);
		}
	};
	
	public ArrayList<HashMap<String, Object>> getBoardList(int pageNum, String searchOption, String searchWord) {
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<>();
		ArrayList<BoardVo> boardVoList = boardSQLMapper.selectBoardList(pageNum, searchOption, searchWord);
		
		for(BoardVo boardVo : boardVoList) {
			boardVo.setBoard_title(StringUtil.escapeHTML(boardVo.getBoard_title()));
			String board_content = StringUtil.escapeHTML(boardVo.getBoard_content());
			if(board_content.length() > 50) {
				board_content = board_content.substring(0, 50).concat("...");
			}

			boardVo.setBoard_content(board_content);			

			MemberVo memberVo = memberSQLMapper.getMemberByNo(boardVo.getMember_no());
			
			int board_no = boardVo.getBoard_no();
			BoardImageVo boardImageVo = boardSQLMapper.selectBoardImageThumbnailByBoardNo(board_no);
			
			if(boardImageVo == null) {
				boardImageVo = new BoardImageVo();
				boardImageVo.setBoard_no(board_no);
				boardImageVo.setImage_url("../resources/img/default_thumbnail.jpg");
			}
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("boardVo", boardVo);
			map.put("memberVo", memberVo);
			map.put("boardImageVo", boardImageVo);
			
			resultList.add(map);
		}
		
		return resultList;
	}
	
	public int getTotalBoardCount(String searchOption, String searchWord) {
		return boardSQLMapper.selectTotalBoardCount(searchOption, searchWord);
	}
	
	public HashMap<String, Object> getBoard(int board_no) {
		HashMap<String, Object> resultVo = boardSQLMapper.selectBoardByNo(board_no);
		resultVo.put("board_title",StringUtil.escapeHTML((String) resultVo.get("board_title")));
		resultVo.put("board_content",StringUtil.escapeHTML((String) resultVo.get("board_content")));
		
		return resultVo;
	}
	
	public ArrayList<BoardImageVo> getBoardImage(int board_no) {
		return boardSQLMapper.selectBoardImageByBoardNo(board_no);
	}
	
	public void modifyBoard(BoardVo vo) {
		boardSQLMapper.updateBoard(vo);	
	}
	
	public void addBoardImage(BoardImageVo vo) {
		boardSQLMapper.insertBoardImage(vo);
	}
	
	public void delBoardImageByNo(int no) {
		boardSQLMapper.deleteBoardByNo(no);
	}
	
	public void delBoardByNo(int no) {
		boardSQLMapper.deleteBoardByNo(no);
	}
	
	public void delBoardImageByBoardNo(int board_no) {
		boardSQLMapper.deleteBoardImaegeByBoardNo(board_no);
	}
}
