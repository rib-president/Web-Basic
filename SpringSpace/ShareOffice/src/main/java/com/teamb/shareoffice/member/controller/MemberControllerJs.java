package com.teamb.shareoffice.member.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamb.shareoffice.member.service.MemberServiceJs;
import com.teamb.shareoffice.vo.MemberVo;
import com.teamb.shareoffice.vo.MessageVo;

@Controller
@RequestMapping("/member/*")
public class MemberControllerJs {
	
	@Autowired
	private MemberServiceJs memberServiceJs;
	
	@RequestMapping("messageListPage")
	public String messageListPage(Model model) {
		
		
		ArrayList<HashMap<String, Object>> datalist = memberServiceJs.getMessageList();
		
		model.addAttribute("datalist", datalist);
		
		return "member/messageListPage";
	}
	
	@RequestMapping("loginProcess")
	public String loginProcess(HttpSession session, MemberVo param) {
		
		param.setMember_no(2);
		int setNo = param.getMember_no();
		session.setAttribute("sessionUser",param);
		System.out.println("로그인프로세스");
		System.out.println("setNo = " + setNo);
		System.out.println("param = " + param);
		
		return "redirect:../member/messageListPage";
	}
	
	@RequestMapping("writeMessagePage")
	public String writeMessagePage(HttpSession session , MemberVo param) {
		
		param.setMember_no(2);
		param.setMember_nick("메르시");
		int setNo = param.getMember_no();
		session.setAttribute("sessionUser",param);
		System.out.println("로그인프로세스");
		System.out.println("setNo = " + setNo);
		System.out.println("param = " + param);
		
		return "member/writeMessagePage";
	}
	
	@RequestMapping("writeMessageProcess")
	public String writeMessageProcess(MemberVo mVo, MessageVo sVo, HttpSession session) {
		
		MemberVo sessionUser = (MemberVo) session.getAttribute("sessionUser");		
		
		int senderNo = sessionUser.getMember_no();
		sVo.setSender_no(senderNo);		
		
		memberServiceJs.writeMessage(sVo);				
		
		return "redirect:./messageListPage";
	}
}
