package com.ja.rubatoex.member.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ja.rubatoex.member.service.MemberService;
import com.ja.rubatoex.vo.MailAuthVO;
import com.ja.rubatoex.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("joinMemberPage")
	public String joinMemberPage(HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("sessionUser") != null) {
			
			String referer = (request.getHeader("referer")!=null ? request.getHeader("referer") : request.getRequestURI());
			
			String[] splitReferer = referer.split("/");
			String[] tailReferer = Arrays.copyOfRange(splitReferer, 4, splitReferer.length); 
			String joinReferer = String.join("/", tailReferer);
			
			request.setAttribute("redirectPath", joinReferer);
			
			return "member/denyJoinMember";
		}
		
		return "member/joinMemberPage";
	}
	
	@RequestMapping("joinMemberProcess")
	public String joinMemberProcess(MemberVO vo, Model model) {	
		memberService.joinMember(vo);
		
		return "redirect:../main/main";
	}
	
	@RequestMapping("mailAuthPage")
	public String mailAuthPage(int member_no, @RequestParam(value = "deny_no", defaultValue = "0") int deny_no, Model model) {
		model.addAttribute("member_no", member_no);
		model.addAttribute("deny_no", deny_no);
		return "member/mailAuthPage";
	}
	
	@RequestMapping("mailAuthProcess")
	public String mailAuthProcess(MailAuthVO vo) {

		MailAuthVO resultVO = memberService.getMailAuthByMemberNo(vo.getMember_no());
		
		if(resultVO.getMailauth_complete().equals("Y")) {
			return "member/mailAuthComplete";
		}
		
		if(resultVO.getMailauth_exp().before(new Date())) {

			return "redirect:../member/mailAuthPage?member_no=" + vo.getMember_no() + "&deny_no=" + 1;
		} else if(!vo.getMailauth_key().equals(resultVO.getMailauth_key())) {

			return "redirect:../member/mailAuthPage?member_no=" + vo.getMember_no() + "&deny_no=" + 2;
		}
		
		memberService.completeMailAuth(vo.getMember_no());
		
		return "member/mailAuthComplete";
	}
	
	@RequestMapping("resendMailAuthProcess")
	public String resendMailAuthProcess(int member_no) {
		if(memberService.getMailAuthByMemberNo(member_no).getMailauth_complete().equals("Y")) {
			return "member/mailAuthComplete";
		}
		
		memberService.resendMailAuth(member_no);
		
		return "redirect:../member/mailAuthPage?member_no=" + member_no;
	}
	
	@RequestMapping("loginProcess")
	public String loginProcess(MemberVO vo, HttpSession session, HttpServletRequest request, Model model) {
		MemberVO resultVO = memberService.login(vo);
		String referer = (request.getHeader("referer")!=null ? request.getHeader("referer") : request.getRequestURI());
		
		String[] splitReferer = referer.split("/");
		String[] tailReferer = Arrays.copyOfRange(splitReferer, 4, splitReferer.length); 
		String joinReferer = String.join("/", tailReferer);
		
		if(resultVO == null) {
			model.addAttribute("redirectPath", joinReferer);
			return "member/loginFail";
		}
		
		if(memberService.getMailAuthByMemberNo(resultVO.getMember_no()).getMailauth_complete().equals("N")) {
			model.addAttribute("member_no", resultVO.getMember_no());
			return "member/requiredMailAuth";
		}
		
		session.setAttribute("sessionUser", resultVO);
		
		return "redirect:../" + joinReferer;
	}
	
	@RequestMapping("logoutProcess")
	public String logoutProcess(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		
		String referer = (request.getHeader("referer")!=null ? request.getHeader("referer") : request.getRequestURI());
		
		String[] splitReferer = referer.split("/");
		String joinReferer = "main/main";
		
		if(splitReferer[4].equals("board")) {
			String[] tailReferer = Arrays.copyOfRange(splitReferer, 4, splitReferer.length); 
			joinReferer = String.join("/", tailReferer);
		}
		
		return "redirect:../" + joinReferer;
	}
}
