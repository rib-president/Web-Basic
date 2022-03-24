package com.teamb.shareoffice.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.teamb.shareoffice.vo.FreeBoardCommentVo;
import com.teamb.shareoffice.vo.FreeBoardVo;

@Mapper
public interface BoardMapperkt {
	//게시글 등록
	public void insertFreeBoard(FreeBoardVo vo);
	//게시판 쿼리
	public ArrayList<FreeBoardVo> getFreeBoardList(int pageNum);
	//게시글 읽기
	public FreeBoardVo readFreeBoardRow(int freeboard_no);
	//조회수 증가
	public void increaseFreeBoardReadCount(int freeboard_no);
	//게시글 삭제
	public void deleteFreeBoardRow(int freeboard_no);
	//게시글 수정
	public void fixFreeBoardRow(FreeBoardVo vo);
	//코멘트 등록
	public void insertFreeBoardComment(FreeBoardCommentVo vo);
	//코멘트 쿼리
	public ArrayList<FreeBoardCommentVo> getFreeBoardCommentList();
	//게시판 등록글 갯수 쿼리
	public int getFreeBoardCount();
}
