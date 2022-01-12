package com.ja.finalproject.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.member.mapper.MemberSQLMapper;
import com.ja.finalproject.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void joinMember(MemberVO vo) {
		// 파라미터 데이터를 가지고 코어로직(비즈니스 로직) 수행
		// DB insert

		memberSQLMapper.joinMember(vo);
	}
	
	public MemberVO login(MemberVO vo) {
		MemberVO result = memberSQLMapper.getMemberByIdAndPw(vo);
		
		return result;
	}
}
