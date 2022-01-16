package com.ja.rubatoex.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.rubatoex.member.mapper.MemberSQLMapper;
import com.ja.rubatoex.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void joinMember(MemberVO vo) {
		memberSQLMapper.joinMember(vo);
	}
	
	public MemberVO login(MemberVO vo) {
		MemberVO resultVO = memberSQLMapper.login(vo);
		return resultVO;
	}
	
	public MemberVO getMemberByNo(int no) {
		MemberVO resultVO = memberSQLMapper.selectMemberByNo(no);
		
		return resultVO;
	}
	
	public ArrayList<MemberVO> getMemberByNick(String member_nick) {
		ArrayList<MemberVO> resultVOList = memberSQLMapper.selectMemberByNick(member_nick);
		
		return resultVOList;
	}
}
