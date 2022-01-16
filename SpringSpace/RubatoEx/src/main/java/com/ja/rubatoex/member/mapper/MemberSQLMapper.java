package com.ja.rubatoex.member.mapper;

import java.util.ArrayList;

import com.ja.rubatoex.vo.MemberVO;

public interface MemberSQLMapper {
	public void joinMember(MemberVO vo);
	public MemberVO login(MemberVO vo);
	public MemberVO selectMemberByNo(int no);
	public ArrayList<MemberVO> selectMemberByNick(String member_nick);
}
