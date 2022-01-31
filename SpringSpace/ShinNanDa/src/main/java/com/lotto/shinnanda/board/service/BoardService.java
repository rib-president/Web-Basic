package com.lotto.shinnanda.board.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lotto.shinnanda.board.mapper.BoardSQLMapper;
import com.lotto.shinnanda.commons.StringUtil;
import com.lotto.shinnanda.member.mapper.MemberSQLMapper;
import com.lotto.shinnanda.vo.BoardImageVo;
import com.lotto.shinnanda.vo.BoardVo;
import com.lotto.shinnanda.vo.CommentVo;
import com.lotto.shinnanda.vo.LikeCategoryVo;
import com.lotto.shinnanda.vo.LikeVo;
import com.lotto.shinnanda.vo.MemberVo;

@Service
public class BoardService {
	@Autowired
	private BoardSQLMapper boardSQLMapper;
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public int writeBoard(BoardVo boardVo, ArrayList<BoardImageVo> boardImageVoList) {
		int board_no = boardSQLMapper.createBoardNo();
		
		boardVo.setBoard_no(board_no);
		boardSQLMapper.insertBoard(boardVo);
		
		for(BoardImageVo boardImageVo : boardImageVoList) {
			boardImageVo.setBoard_no(board_no);
			boardSQLMapper.insertBoardImage(boardImageVo);
		}
		
		return board_no;
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
	
	public Map<String, Object> getBoard(int board_no, boolean isEscape) {
		Map<String, Object> resultVo = boardSQLMapper.selectBoardByNo(board_no);

		if(isEscape) {
			resultVo.put("board_title",StringUtil.escapeHTML((String) resultVo.get("BOARD_TITLE")));
			resultVo.put("board_content",StringUtil.escapeHTML((String) resultVo.get("BOARD_CONTENT")));
		}
		
		return resultVo;
	}
	
	public void increaseReadCount(int no) {
		boardSQLMapper.increaseReadCountByNo(no);
	}
	
	public int getBoardReadCount(int no) {
		return boardSQLMapper.selectBoardReadCount(no);
	}
	
	public ArrayList<BoardImageVo> getBoardImage(int board_no) {
		return boardSQLMapper.selectBoardImageByBoardNo(board_no);
	}
	
	public void modifyBoard(BoardVo vo) {
		boardSQLMapper.updateBoard(vo);	
	}
	
	public void addBoardImage(ArrayList<BoardImageVo> voList, int board_no) {
		for(BoardImageVo vo : voList) {
			vo.setBoard_no(board_no);
			boardSQLMapper.insertBoardImage(vo);
		}
	}
	
	public void delBoardImageByNo(int no) {
		boardSQLMapper.deleteBoardImageByNo(no);
	}
	
	public void delBoardByNo(int no) {
		boardSQLMapper.deleteBoardByNo(no);
	}
	
	public void delBoardImageByBoardNo(int board_no) {
		boardSQLMapper.deleteBoardImaegeByBoardNo(board_no);
	}
	
	public void writeComment(CommentVo vo) {
		boardSQLMapper.insertComment(vo);
	}
	
	public ArrayList<HashMap<String, Object>> getCommentList(int board_no) {
		ArrayList<HashMap<String, Object>> voList = boardSQLMapper.selectCommentByBoardNo(board_no);
		
		ArrayList<HashMap<String, Object>> resultVoList = new ArrayList<>();
		for(HashMap<String, Object> map : voList) {
			map.put("COMMENT_CONTENT_NONE_ESCAPE", (String) map.get("COMMENT_CONTENT"));				
			map.put("COMMENT_CONTENT", StringUtil.escapeHTML((String) map.get("COMMENT_CONTENT")));		

			resultVoList.add(map);
		}
		return resultVoList;
	}
	
	public void modifyComment(CommentVo vo) {
		boardSQLMapper.updateComment(vo);
	}
	
	public void delCommentByNo(int no) {
		boardSQLMapper.deleteCommentByNo(no);
	}
	
	public void delCommentByBoardNo(int board_no) {
		boardSQLMapper.deleteCommentByBoardNo(board_no);
	}
	
	public ArrayList<LikeCategoryVo> getLikeCategory() {
		return boardSQLMapper.selectLikeCategory();
	}
	
	public void addLike(LikeVo vo) {
		int[] likecategories = boardSQLMapper.selectMemberBoardLikeCategory(vo);
		
		for(int likecategory : likecategories) {
			LikeVo deleteVo = new LikeVo();
			deleteVo.setBoard_no(vo.getBoard_no());
			deleteVo.setMember_no(vo.getMember_no());
			deleteVo.setLikecategory_no(likecategory);
			boardSQLMapper.deleteMemberBoardLike(deleteVo);
		}
		
		boardSQLMapper.insertLike(vo);
	}
	
	public void cancleLike(LikeVo vo) {
		boardSQLMapper.deleteMemberBoardLike(vo);
	}
	
	public int getMemberBoardLikeCategory(LikeVo vo) {
		int[] likecategories = boardSQLMapper.selectMemberBoardLikeCategory(vo);

		for(int i=0;i<likecategories.length;i++) {
			if(i == 0) continue;
			else {
				vo.setLikecategory_no(likecategories[i]);
				boardSQLMapper.deleteMemberBoardLike(vo);
			}
		}	
		return (likecategories.length > 0) ? likecategories[0] : 0; 
	}
	
	public int getBoardLikeCategoryCount(LikeVo vo) {
		return boardSQLMapper.selectBoardLikeCategoryCount(vo);
	}
}
