package com.ja.finalproject.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.member.mapper.MemberSQLMapper;
import com.ja.finalproject.vo.HobbyCategoryVO;
import com.ja.finalproject.vo.MemberHobbyVO;
import com.ja.finalproject.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void joinMember(MemberVO vo, int[] hobby_category_no) {
		// 파라미터 데이터를 가지고 코어로직(비즈니스 로직) 수행

		// member_no(PK) 먼저 생성
		int memberNo = memberSQLMapper.createMemberPK();
		
		// DB insert
		vo.setMember_no(memberNo);
		memberSQLMapper.joinMember(vo);
		
		if(hobby_category_no != null) {
			
			for(int hcNo : hobby_category_no) {
				
				MemberHobbyVO hVO = new MemberHobbyVO();
				// 회원 번호(dual에서 seq 조회로 받아온 값)
				hVO.setMember_no(memberNo);
				// 취미 카테고리 번호(회원 가입시 선택된 값)
				hVO.setHobby_category_no(hcNo);
				memberSQLMapper.insertMemberHobby(hVO);
				
			}
		}
	}
	
	public MemberVO login(MemberVO vo) {
		MemberVO result = memberSQLMapper.getMemberByIdAndPw(vo);
		
		return result;
	}
	
	public ArrayList<HobbyCategoryVO> getHobbyCategoryList() {
		 return memberSQLMapper.getHobbyCategoryList();
	}
}
