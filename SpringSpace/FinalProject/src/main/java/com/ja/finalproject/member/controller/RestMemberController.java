package com.ja.finalproject.member.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja.finalproject.member.service.MemberService;
import com.ja.finalproject.vo.MemberVO;

@RestController
@RequestMapping("/member/*")
public class RestMemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("isExistId")
	public HashMap<String, Object> isExistId(String id) {
		HashMap<String, Object> data = new HashMap<>();
		
		boolean result = memberService.isExistId(id);
		System.out.println("야호 : " + result );
		data.put("result", result);
		
		return data;
	}
	
	@RequestMapping("getSessionInfo")
	public HashMap<String, Object> getSessionInfo(HttpSession session) {
		HashMap<String, Object> data = new HashMap<>();
		
		MemberVO sessionUser = (MemberVO) session.getAttribute("sessionUser");
		
		if(sessionUser == null) {
			data.put("result", "empty");
		} else {
			data.put("result", "success");
			data.put("memberNo", sessionUser.getMember_no());
			data.put("memberNick", sessionUser.getMember_nick());
		}
		
		return data;
	}
}
