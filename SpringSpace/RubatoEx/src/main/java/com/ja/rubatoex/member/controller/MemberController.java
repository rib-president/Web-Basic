package com.ja.rubatoex.member.controller;

import java.lang.reflect.Field;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.rubatoex.member.service.MemberService;
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
		Object obj = vo;
		try {
			for(Field field : obj.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				
				if(field.getName().equals("member_no") || field.getName().equals("member_joindate")) {
					continue;
				}
				
				Object value=field.get(obj);
				
				if(value == null || value == "") {
					model.addAttribute("isEmpty", 1);
					model.addAttribute("memberVO", vo);
					return "member/joinMemberPage";
				}
			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		memberService.joinMember(vo);
		
		return "redirect:../main/main";
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
			if(splitReferer[5].indexOf("boardViewPage") != -1) {
				String[] tailReferer = Arrays.copyOfRange(splitReferer, 4, splitReferer.length); 
				joinReferer = String.join("/", tailReferer);
			} else {
				joinReferer = splitReferer[4] + "/boardListPage";
			}
		}
		
		return "redirect:../" + joinReferer;
	}
}
