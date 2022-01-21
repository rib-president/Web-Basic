package com.ja.rubatoex.member.mapper;

import java.util.ArrayList;

import com.ja.rubatoex.vo.MailAuthVO;
import com.ja.rubatoex.vo.MemberVO;

public interface MemberSQLMapper {
	public int createMemberNo();
	public void joinMember(MemberVO vo);
	public MemberVO login(MemberVO vo);
	public MemberVO selectMemberByNo(int no);
	public ArrayList<MemberVO> selectMemberByNick(String member_nick);
	
	public void insertMailAuth(MailAuthVO vo);
	public MailAuthVO selectMailAuth(int no);
	public void updateMailAuthComplete(int no);
	public void updateMailAuthKeyAndExp(MailAuthVO vo);
}
