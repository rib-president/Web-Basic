package com.ja.rubatoex.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.rubatoex.commons.MessageDigestUtil;
import com.ja.rubatoex.member.mapper.MemberSQLMapper;
import com.ja.rubatoex.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void joinMember(MemberVO vo) {
		vo.setMember_pw(MessageDigestUtil.passwordHashing(
				vo.getMember_pw()));
		memberSQLMapper.joinMember(vo);
	}
	
	public MemberVO login(MemberVO vo) {
		vo.setMember_pw(MessageDigestUtil.passwordHashing(
				vo.getMember_pw()));	
		return memberSQLMapper.login(vo);
	}
	
	public MemberVO getMemberByNo(int no) {
		return memberSQLMapper.selectMemberByNo(no);
	}
	
	public ArrayList<MemberVO> getMemberByNick(String member_nick) {
		return memberSQLMapper.selectMemberByNick(member_nick);
	}
}
