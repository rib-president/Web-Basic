package com.lotto.shinnanda.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lotto.shinnanda.member.service.MemberService;
import com.lotto.shinnanda.vo.MemberVo;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("loginPage")
	public String mainPage(HttpSession session) {
		if(session.getAttribute("sessionUser") != null || session.getAttribute("sessionAdmin") != null) {
			return "member/loginDuplicate";
		}
		
		
		System.out.println("시스템 로그] 메인 페이지가 실행되었습니다.");
		return "member/loginPage";
	
	}
	
	@RequestMapping("joinMemberPage")
	public String joinMemberPage(HttpSession session) {
		
		System.out.println("시스템 로그] 회원가입 페이지 실행");
		
		if(session.getAttribute("sessionUser") != null || session.getAttribute("sessionAdmin") != null) {
			return "member/loginDuplicate";
		}
		
				
		return "member/joinMemberPage";
	}
	
	@RequestMapping("joinMemberProcess")
	public String joinMemberProcess(MemberVo param) {
		
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
	public String loginProcess(MemberVo param , HttpSession session) {
		
		System.out.println("시스템 로그] 로그인 프로세스 실행");
		
		MemberVo sessionUser = memberService.login(param);
		
		if(sessionUser == null) {
			//인증(로그인) 실패
			return "member/loginFail";			
		}			
		
		//인증(로그인) 성공
		if(sessionUser.getMember_admin().equals("N")) {
			session.setAttribute("sessionUser", sessionUser);
			
			return "redirect:../shop/main";			
		} else {
			session.setAttribute("sessionAdmin", sessionUser);
			
			return "redirect:../admin/main";
		}	
	}
	
	@RequestMapping("logoutProcess")
	public String logoutProcess(HttpSession session) {
		session.invalidate();
		
		return "redirect:../shop/main";
	}
	
	@RequestMapping("memberInfo")
	public String memberInfo() {

		return "member/memberInfo";
	}
	
//	@RequestMapping("modifyMemberInfo")
//	public String modifyMemberInfo(MemberVo vo, HttpSession session) {
//		int member_no = ((MemberVo) session.getAttribute("sessionUser")).getMember_no();
//		vo.setMember_no(member_no);
//		
//		memberService.modifyMemberInfo(vo);
//		
//		
//		session.setAttribute("sessionUser", memberService.getMemberByNo(member_no));
//		
//		return "member/memberInfo";
//	}

}
