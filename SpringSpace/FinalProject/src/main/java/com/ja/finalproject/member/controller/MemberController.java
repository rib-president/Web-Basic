package com.ja.finalproject.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ja.finalproject.member.service.MemberService;
import com.ja.finalproject.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping("loginPage")
	public String loginPage() {
		System.out.println("시스템 로그] 로그인 페이지 실행");
		
		return "member/loginPage";
	}
	
	@RequestMapping("joinMemberPage")
	public String joinMemberPage() {
		System.out.println("시스템 로그] 회원가입 페이지 실행");
		
		return "member/joinMemberPage";
	}
	
	@RequestMapping("joinMemberProcess")
	public String joinMemberProcess(MemberVO param) {
		System.out.println("시스템 로그] 회원가입 프로세스 실행");
		System.out.println("시스템 로그] 파라미터 값 id : " + param.getMember_id());
		System.out.println("시스템 로그] 파라미터 값 pw : " + param.getMember_pw());
		System.out.println("시스템 로그] 파라미터 값 nick : " + param.getMember_nick());
		System.out.println("시스템 로그] 파라미터 값 gender : " + param.getMember_gender());
		System.out.println("시스템 로그] 파라미터 값 birth : " + param.getMember_birth());
		System.out.println("시스템 로그] 파라미터 값 phone : " + param.getMember_phone());
		System.out.println("시스템 로그] 파라미터 값 email : " + param.getMember_email());
		
		memberService.joinMember(param);
		
		return "member/joinMemberComplete";
	}
}
