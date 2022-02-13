package com.lotto.shinnanda.member.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lotto.shinnanda.member.service.MemberService;
import com.lotto.shinnanda.vo.MemberVo;

@RestController
@RequestMapping("/member/*")
public class RestMemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("getMemberInfo")
	public HashMap<String, Object> getMemberInfo(int member_no) {
		
		HashMap<String, Object> data = new HashMap<>();
		
		data.put("memberVo", memberService.getMemberByNo(member_no));
		
		return data;
	}
	
	@RequestMapping("modifyMemberInfo")
	public HashMap<String, Object> modifyMemberInfo(@RequestBody Map<String, String> params, HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<>();
		
		MemberVo vo = new MemberVo();
		int member_no = 0;
		MemberVo sessionUser = (MemberVo) session.getAttribute("sessionUser");
		if(sessionUser != null) {
			member_no = sessionUser.getMember_no();
			vo.setMember_no(member_no);
		} else {
			member_no = Integer.parseInt(params.get("member_no"));
			vo.setMember_no(member_no);
			vo.setMember_name(params.get("member_name"));
			vo.setMember_gender(params.get("member_gender"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				vo.setMember_birth(sdf.parse(params.get("member_birth")));
			} catch (ParseException e) {
				e.printStackTrace();
			}			
		}
		vo.setMember_pw(params.get("member_pw"));

		vo.setMember_nick(params.get("member_nick"));
		
		vo.setMember_phone(params.get("member_phone"));
		vo.setMember_address(params.get("member_address"));
		vo.setMember_email(params.get("member_email"));
		
		memberService.modifyMemberInfo(vo);
		
		if(sessionUser != null) {
			session.setAttribute("sessionUser", memberService.getMemberByNo(member_no));
		}
		
		data.put("member_no", member_no);

		return data;
	}
}
