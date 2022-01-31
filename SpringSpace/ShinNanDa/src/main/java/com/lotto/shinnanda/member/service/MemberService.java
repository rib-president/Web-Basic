package com.lotto.shinnanda.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lotto.shinnanda.member.mapper.MemberSQLMapper;
import com.lotto.shinnanda.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void joinMember(MemberVo vo) {
		
		// 파라미터 데이터를 가지고 .. 코어로직(비지니스 로직) 수행한다..!
		// DB... insert
		memberSQLMapper.joinMember(vo);
		
	}
	
	public MemberVo login(MemberVo vo) {
		
		MemberVo result = memberSQLMapper.getMemberByIdAndPw(vo);
		
		return result;
		
	}
	
	public MemberVo getMemberByNo(int no) {
		return memberSQLMapper.getMemberByNo(no);
	}

	public void modifyMemberInfo(MemberVo vo) {
		memberSQLMapper.updateMemberVo(vo);
	}
	
}
