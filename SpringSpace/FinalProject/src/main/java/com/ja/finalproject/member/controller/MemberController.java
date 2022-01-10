package com.ja.finalproject.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
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
	public String joinMemberProcess(String id, String pw) {
		System.out.println("시스템 로그] 회원가입 프로세스 실행");
		System.out.println("시스템 로그] 파라미터 값 id : " + id);
		System.out.println("시스템 로그] 파라미터 값 pw : " + pw);
		
		return "";
	}
}
