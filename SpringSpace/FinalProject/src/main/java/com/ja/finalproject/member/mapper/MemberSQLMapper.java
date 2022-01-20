package com.ja.finalproject.member.mapper;

import java.util.ArrayList;

import com.ja.finalproject.vo.HobbyCategoryVO;
import com.ja.finalproject.vo.MailAuthVO;
import com.ja.finalproject.vo.MemberHobbyVO;
import com.ja.finalproject.vo.MemberVO;

public interface MemberSQLMapper {
	public int createMemberPK();
	
	public void joinMember(MemberVO vo);	// insert
	public MemberVO getMemberByIdAndPw(MemberVO vo);	// select
	
	public MemberVO getMemberByNo(int no);
	
	// 취미 카테고리 관련
	public ArrayList<HobbyCategoryVO> getHobbyCategoryList();
	
	// 회원 취미 관련
	public void insertMemberHobby(MemberHobbyVO vo);
	
	// 메일 인증 관련
	public void insertMailAuth(MailAuthVO vo);
	public void updateMailAuthComplete(String authKey);
}
