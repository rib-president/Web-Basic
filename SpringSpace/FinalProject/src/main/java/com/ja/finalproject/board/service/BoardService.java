package com.ja.finalproject.board.service;

import java.util.*;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.board.mapper.BoardSQLMapper;
import com.ja.finalproject.member.mapper.MemberSQLMapper;
import com.ja.finalproject.vo.BoardImageVO;
import com.ja.finalproject.vo.BoardLikeVO;
import com.ja.finalproject.vo.BoardVO;
import com.ja.finalproject.vo.CommentVO;
import com.ja.finalproject.vo.MemberVO;

@Service
public class BoardService {
	@Autowired
	private BoardSQLMapper boardSQLMapper;
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void writeContent(BoardVO vo, ArrayList<BoardImageVO> boardImageVOList) {
		// 실제는 유효성 검사해야하는 부분(제목에 욕 같은거)
		int boardNo = boardSQLMapper.createBoardPK();
		
		vo.setBoard_no(boardNo);
		boardSQLMapper.insertBoard(vo);
		
		for(BoardImageVO boardImageVO : boardImageVOList) {
			boardImageVO.setBoard_no(boardNo);
			boardSQLMapper.insertImage(boardImageVO);
		}
	}
	
	public ArrayList<HashMap<String, Object>> getBoardList(
			String searchOption, String searchWord, int pageNum) {
		ArrayList<HashMap<String, Object>> dataList = new ArrayList<>();
		
		ArrayList<BoardVO> boardVOList = boardSQLMapper.getBoardList(searchOption, searchWord, pageNum);
		
		for(BoardVO boardVO : boardVOList) {
			int memberNo = boardVO.getMember_no();	// 작성자 번호			
			
			// 제목에 escape 적용
			boardVO.setBoard_title(
					StringEscapeUtils.escapeHtml4(boardVO.getBoard_title())
					.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;"));
			
			// SELECT * FROM FP_Member WHERE member_no = #{no}
			MemberVO memberVO = memberSQLMapper.getMemberByNo(memberNo);
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("memberVO", memberVO);
			map.put("boardVO", boardVO);
			
			// 게시글이 지금시간 -3시간 보다 클 때(숫자로 변환하여 연산)
			Date writeDate = boardVO.getBoard_writedate();
			long writeTime = writeDate.getTime();
			
			long currentTime = System.currentTimeMillis();
			long targetTime = currentTime - 1000 * 60 * 60 * 3;
			
			if(writeTime > targetTime) {
				map.put("newKeyword", true);
			}
			
			dataList.add(map);
		}
		return dataList;
	}
	
	
	public int getBoardCount(String searchOption, String searchWord) {
		return boardSQLMapper.getBoardCount(searchOption, searchWord);
	}
	
	
	public HashMap<String, Object> getBoard(int board_no, boolean isEscape) {
		HashMap<String, Object> map = new HashMap<>();
		
		BoardVO boardVO = boardSQLMapper.getBoardByNo(board_no);
		
		// HTML escape
		if(isEscape) {
			String content = boardVO.getBoard_content();
			
			// StringEscapeUtils가 두 종류 있음
			// org.apache.commons.text.StringEscapeUtils 사용
			content = StringEscapeUtils.escapeHtml4(content);
			
			// 엔터를 <br>로 치환(StringEscapeUtils는 엔터를 <br>로 안 바꿔줌)
			// HTML은 띄어쓰기 한 번만 인식 => 띄어쓰기를 띄어쓰기 특문으로 직접 치환
			// 직접 코드 상에서 수정해야함
			content = content.replaceAll("\n", "<br>");
			content = content.replaceAll(" ", "&nbsp;");
			boardVO.setBoard_content(content);
			
			// 제목에도 escape 적용
			boardVO.setBoard_title(
					StringEscapeUtils.escapeHtml4(boardVO.getBoard_title())
					.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;"));
			
		}
				
		int memberNo = boardVO.getMember_no();	
		MemberVO memberVO = memberSQLMapper.getMemberByNo(memberNo);
		
		ArrayList<BoardImageVO> boardImageVOList = 
				boardSQLMapper.getImageListByBoardNo(board_no);
		
		
		map.put("memberVO", memberVO);
		map.put("boardVO", boardVO);
		map.put("boardImageVOList", boardImageVOList);
		
		return map;
	}
	
	public void increaseReadCount(int board_no) {
		boardSQLMapper.increaseReadCount(board_no);
	}
	
	public void deleteBoard(int board_no) {
		// 정말 지워도 되는지 예외처리를 많이 해야 함
		// 실제론 다른 사람이 지울 수도 있어 보안 관련 처리 필요
		boardSQLMapper.deleteBoard(board_no);
	}
	
	public void updateBoard(BoardVO vo) {
		boardSQLMapper.updateBoard(vo);
	}
	
	// 좋아요
	public void doLike(BoardLikeVO vo) {
		int count = boardSQLMapper.getMyLikeCount(vo);
		
		if(count > 0) {
			boardSQLMapper.deleteLike(vo);
		} else {
			boardSQLMapper.insertLike(vo);
		}
	}
	
	public int getTotalLikeCount(int boardNo) {
		
		return boardSQLMapper.getTotalLikeCount(boardNo);
	}
	
	public int getMyLikeCount(BoardLikeVO vo) {
		return boardSQLMapper.getMyLikeCount(vo);
	}
	
	// 리플
	public void insertComment(CommentVO vo) {
		boardSQLMapper.insertComment(vo);
	}
	
	public void deleteComment(int commentNo) {
		boardSQLMapper.deleteComment(commentNo);
	}
	
	public void updateComment(CommentVO vo) {
		boardSQLMapper.updateComment(vo);
	}
	
	public ArrayList<HashMap<String, Object>> getCommentList(int boardNo) {
		return boardSQLMapper.getCommentListByBoardNo(boardNo);
	}
	
}
