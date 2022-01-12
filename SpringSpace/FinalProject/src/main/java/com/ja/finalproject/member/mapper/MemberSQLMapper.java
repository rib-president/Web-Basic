package com.ja.finalproject.member.mapper;

import com.ja.finalproject.vo.MemberVO;

public interface MemberSQLMapper {
	public void joinMember(MemberVO vo);	// insert
	public MemberVO getMemberByIdAndPw(MemberVO vo);	// select
}
