package com.ja.finalproject.member.controller;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("loginProcess")
	// HttpSession : session 저장공간
	public String loginProcess(MemberVO param, HttpSession session) {
		System.out.println("시스템 로그] 로그인 프로세스 실행");
		
		MemberVO sessionUser = memberService.login(param);
		
		if(sessionUser != null) {
			// 인증 성공 - session에 인증 정보 담기
			// 신경 쓸 것. 딱 한 번 setAttribute함, getAttribute는 많이 사용됨
			// => getAttribute했는데 null이면 로그인 안 한 것
			session.setAttribute("sessionUser", sessionUser);

			// 로그인 성공 시 redirect
			return "redirect:../board/mainPage";
		} else {
			// 인증 실패(forwarding)
			return "member/loginFail";
		}
	}
	
	@RequestMapping("logoutProcess")
	public String logoutProcess(HttpSession session) {
		System.out.println("시스템 로그] 로그아웃 프로세스 실행");
		
		// 세션 저장 공간을 날리고 재구성 => 세션 무효화
		session.invalidate();
		return "redirect:../board/mainPage";
	}
}
