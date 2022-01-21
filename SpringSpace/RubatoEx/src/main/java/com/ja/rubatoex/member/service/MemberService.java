package com.ja.rubatoex.member.service;

import java.util.ArrayList;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import com.ja.rubatoex.commons.MailSenderThread;
import com.ja.rubatoex.commons.MessageDigestUtil;
import com.ja.rubatoex.member.mapper.MemberSQLMapper;
import com.ja.rubatoex.vo.MailAuthVO;
import com.ja.rubatoex.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void joinMember(MemberVO vo) {
		int member_no = memberSQLMapper.createMemberNo();
		
		vo.setMember_no(member_no);
		vo.setMember_pw(MessageDigestUtil.passwordHashing(
				vo.getMember_pw()));
		memberSQLMapper.joinMember(vo);
		
		MailAuthVO mailAuthVO = new MailAuthVO();
		mailAuthVO.setMember_no(member_no);
		
		UUID uuid = UUID.randomUUID();
		String authKey = uuid.toString();
		mailAuthVO.setMailauth_key(authKey);
		
		memberSQLMapper.insertMailAuth(mailAuthVO);
			
		String mailSubject = "[인증메일] 회원가입을 축하드립니다.";

		String mailText = "";
		mailText += "회원 가입을 축하드립니다. 링크를 클릭하면 나타나는 입력란에 아래 인증키를 입력해주세요.<br>";
		mailText += "인증키 : " + authKey + "<br>";
		mailText += "<a href='http://localhost:8181/rubatoex/member/mailAuthPage?member_no=" + member_no + "'>인증 링크</a>";
		
		MailSenderThread mst = new MailSenderThread(javaMailSender, vo.getMember_email(), mailSubject, mailText);
		
		mst.start();
	}
	
	public MailAuthVO getMailAuthByMemberNo(int member_no) {
		return memberSQLMapper.selectMailAuth(member_no);
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
	
	public void completeMailAuth(int member_no) {
		memberSQLMapper.updateMailAuthComplete(member_no);
	}
	
	public void resendMailAuth(int member_no) {
		MailAuthVO vo = new MailAuthVO();
		vo.setMember_no(member_no);
		
		UUID uuid = UUID.randomUUID();
		String authKey = uuid.toString();
		vo.setMailauth_key(authKey);
		
		memberSQLMapper.updateMailAuthKeyAndExp(vo);
			
		String mailSubject = "[인증메일] 인증메일 재발송";

		String mailText = "";
		mailText += "<h1>링크를 클릭하면 나타나는 입력란에 아래 인증키를 입력해주세요.</h1><br>";
		mailText += "인증키 : " + authKey + "<br>";
		mailText += "<a href='http://localhost:8181/rubatoex/member/mailAuthPage?member_no=" + member_no + "'>인증 링크</a>";

		MailSenderThread mst = new MailSenderThread(javaMailSender, memberSQLMapper.selectMemberByNo(member_no).getMember_email(), mailSubject, mailText);
		
		mst.start();
	}
}
