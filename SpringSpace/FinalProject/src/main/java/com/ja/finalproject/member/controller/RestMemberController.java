package com.ja.finalproject.member.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja.finalproject.member.service.MemberService;

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
}
