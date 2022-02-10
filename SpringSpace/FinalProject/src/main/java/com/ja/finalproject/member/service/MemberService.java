package com.ja.finalproject.member.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ja.finalproject.commons.MailSenderThread;
import com.ja.finalproject.commons.MessageDigestUtil;
import com.ja.finalproject.member.mapper.MemberSQLMapper;
import com.ja.finalproject.vo.HobbyCategoryVO;
import com.ja.finalproject.vo.MailAuthVO;
import com.ja.finalproject.vo.MemberHobbyVO;
import com.ja.finalproject.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void joinMember(MemberVO vo, int[] hobby_category_no) {
		// 파라미터 데이터를 가지고 코어로직(비즈니스 로직) 수행

		// member_no(PK) 먼저 생성
		int memberNo = memberSQLMapper.createMemberPK();
		
		// DB insert
		vo.setMember_no(memberNo);
		
		// 비밀번호 해싱
		String password = vo.getMember_pw();
		password = MessageDigestUtil.getPasswordHashCode(password);
		vo.setMember_pw(password);
		
		memberSQLMapper.joinMember(vo);
		
		// hobby insert
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
		
		// 메일 인증 관련
		// UUID도 특정 길이 문자 반환을 해서 충돌 위험은 있음
		UUID uuid = UUID.randomUUID();
		String authKey = uuid.toString();
		
		MailAuthVO mailAuthVO = new MailAuthVO();
		mailAuthVO.setMailauth_key(authKey);
		mailAuthVO.setMember_no(memberNo);
		
		memberSQLMapper.insertMailAuth(mailAuthVO);
		
		
		// 인증키를 메일로 전송
		String text= "";
		text += "회원가입을 축하드립니다. 아래 링크를 클릭하셔서 메일 인증 완료를 부탁드립니다.<br>";
		text += "<a href='http://localhost:8181/finalproject/member/mailAuthProcess?authKey=" + authKey + "'>메일 인증하기</a>";
		
		MailSenderThread mst = new MailSenderThread(
				javaMailSender, vo.getMember_email(), text); 
		
		mst.start();

	}
	
	public boolean isExistId(String id) {
		
		int count = memberSQLMapper.getCountById(id);
		
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public MemberVO login(MemberVO vo) {
		
		// 비밀번호 해싱
		String password = vo.getMember_pw();
		//password = MessageDigestUtil.getPasswordHashCode(password);
		vo.setMember_pw(password);
		
		MemberVO result = memberSQLMapper.getMemberByIdAndPw(vo);
		
		return result;
	}
	
	public ArrayList<HobbyCategoryVO> getHobbyCategoryList() {
		 return memberSQLMapper.getHobbyCategoryList();
	}
	
	public void authMail(String key) {
		memberSQLMapper.updateMailAuthComplete(key);
	}
}
