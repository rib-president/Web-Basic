package com.teamb.shareoffice.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.shareoffice.board.mapper.BoardMapperkt;
import com.teamb.shareoffice.member.mapper.MemberMapperkt;
import com.teamb.shareoffice.vo.FreeBoardCommentVo;
import com.teamb.shareoffice.vo.FreeBoardVo;
import com.teamb.shareoffice.vo.MemberVo;

@Service
public class BoardServicekt {
	
	@Autowired
	private BoardMapperkt boardMapperkt;
	@Autowired
	private MemberMapperkt memberMapperkt;
	
	public ArrayList<HashMap<String, Object>> getFreeBoardList(int pageNum){
		
		ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>(); 
		//다른방법 생각하자 (수정)
		if(pageNum == 2) {
			pageNum = 10;
		}else if(pageNum == 3) {
			pageNum = 20;
		}else if(pageNum == 4) {
			pageNum = 30;
		}else {
			pageNum = 0;
		}
		
		
		ArrayList<FreeBoardVo> freeBoardList = boardMapperkt.getFreeBoardList(pageNum);
		
		for(FreeBoardVo freeBoardVo : freeBoardList) {
			
			int memberNo = freeBoardVo.getMember_no();
			MemberVo memberVo = memberMapperkt.getMemberByNo(memberNo);
			
			HashMap<String, Object> addList = new HashMap<String, Object>();
			addList.put("freeBoardVo", freeBoardVo);
			addList.put("memberVo", memberVo);
			
			dataList.add(addList);
			
		}
		
		return dataList;
	}

	public void insertFreeBoard(FreeBoardVo vo) {
		boardMapperkt.insertFreeBoard(vo);
	}
	
	public HashMap<String, Object> readFreeBoardRow(int freeboard_no) {
		HashMap<String, Object> result = new HashMap<String, Object>(); 
		
		FreeBoardVo freeBoardRow = boardMapperkt.readFreeBoardRow(freeboard_no);
		int member_no = freeBoardRow.getMember_no();
		MemberVo memberVo = memberMapperkt.getMemberByNo(member_no);
		
		result.put("freeBoardVo", freeBoardRow);
		result.put("memberVo", memberVo);
	
		return result;
	}
	
	public void increaseFreeBoardReadCount(int freeboard_no) {
		boardMapperkt.increaseFreeBoardReadCount(freeboard_no);
	}
	
	public void deleteFreeBoardRow(int freeboard_no) {
		boardMapperkt.deleteFreeBoardRow(freeboard_no);
	}
	
	public void fixFreeBoardRow(FreeBoardVo vo) {
		boardMapperkt.fixFreeBoardRow(vo);
	}
	
	public void insertFreeBoardComment(FreeBoardCommentVo vo) {
		boardMapperkt.insertFreeBoardComment(vo);
	}
	
	public ArrayList<HashMap<String, Object>> getFreeBoardCommentList(){
		
		ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>(); 
		
		ArrayList<FreeBoardCommentVo> freeBoardCommentList = boardMapperkt.getFreeBoardCommentList();
		
		for(FreeBoardCommentVo freeBoardCommentVo : freeBoardCommentList) {
			
			int memberNo = freeBoardCommentVo.getMember_no();
			MemberVo memberVo = memberMapperkt.getMemberByNo(memberNo);
			
			HashMap<String, Object> addList = new HashMap<String, Object>();
			addList.put("freeBoardCommentVo", freeBoardCommentVo);
			addList.put("memberVo", memberVo);
			
			dataList.add(addList);
			
		}
		
		return dataList;
	}
	
	public int getFreeBoardCount() {

		return boardMapperkt.getFreeBoardCount();
	}


}
