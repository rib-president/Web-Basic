package com.teamb.shareoffice.member.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamb.shareoffice.member.service.MemberServiceRN;

@RestController
@RequestMapping("/member/*")
public class RestControllerRN {
	
	@Autowired
	private MemberServiceRN memberService; 
	
	@RequestMapping
	public HashMap<String, Object> getJSKey() {
		HashMap<String, Object> data = new HashMap<>();

		data.put("jsKey", memberService.getJSKey());
		
		return data;
	}
}
