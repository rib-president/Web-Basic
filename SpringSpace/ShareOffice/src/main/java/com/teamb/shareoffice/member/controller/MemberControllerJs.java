package com.teamb.shareoffice.member.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamb.shareoffice.member.service.MemberServiceJs;
import com.teamb.shareoffice.vo.MemberVo;
import com.teamb.shareoffice.vo.MessageVo;

@Controller
@RequestMapping("/member/*")
public class MemberControllerJs {
	
	@Autowired
	private MemberServiceJs memberServiceJs;
	
	@RequestMapping("messageListPage") // 받은쪽지함
	public String messageListPage(Model model,HttpSession session) {
		
		MemberVo sessionUser = (MemberVo) session.getAttribute("sessionUser");
		int rNo = sessionUser.getMember_no();
		
		ArrayList<HashMap<String, Object>> datalist = memberServiceJs.getMessageList(rNo);
		model.addAttribute("datalist", datalist);
		
		return "member/messageListPage";
	}
	
	@RequestMapping("sendMessageListPage") // 보낸쪽지함
	public String sendMessageListPage(Model model,HttpSession session) {
		
		MemberVo sessionUser = (MemberVo) session.getAttribute("sessionUser");
		int sNo = sessionUser.getMember_no();
		
		ArrayList<HashMap<String, Object>> datalist = memberServiceJs.getSendMessageList(sNo);
		model.addAttribute("datalist", datalist);
		
		return "member/sendMessageListPage";
	}
	
	
	@RequestMapping("writeMessagePage") // 쪽지 쓰기
	public String writeMessagePage() {
		
		return "member/writeMessagePage";
	}
	
	@RequestMapping("writeMessageProcess")
	public String writeMessageProcess(MemberVo mVo, MessageVo sVo, HttpSession session, String nick) {
		
		MemberVo sessionUser = (MemberVo) session.getAttribute("sessionUser");
		int senderNo = sessionUser.getMember_no();
		sVo.setSender_no(senderNo);
		
		MemberVo getNickInfo = memberServiceJs.getMemberNick(nick);
		int receiveNo = getNickInfo.getMember_no();
		sVo.setReceive_no(receiveNo);
		
		memberServiceJs.writeMessage(sVo);
		return "redirect:./messageListPage";
	}
	
	@RequestMapping("messageReplyPage") // 답장
	public String replyPage(int sender_no, Model model) {
		
		HashMap<String, Object> map = memberServiceJs.getSender(sender_no);
		model.addAttribute("data", map);
		
		return "member/messageReplyPage";
	}
	
	@RequestMapping("replyMessageProcess")
	public String replyMessageProcess(MemberVo mVo, MessageVo sVo, HttpSession session) {
		
		MemberVo sessionUser = (MemberVo) session.getAttribute("sessionUser");
		int senderNo = sessionUser.getMember_no();
		sVo.setSender_no(senderNo);
		
		memberServiceJs.writeMessage(sVo);
		
		return "redirect:./messageListPage";
	}
	
	@RequestMapping("testMyPage")
	public String testMainPage() {
		
		return "member/testMyPage";
	}
	
	@RequestMapping("logoutProcess")
	public String logoutProcess(HttpSession session) {
		
		session.removeAttribute("sessionUser");
		session.removeAttribute("applyHost");
		
		return "redirect:../guest/mainPage";
	}
	
	@ResponseBody
	@RequestMapping("newMessage")
	public HashMap<String, Object> newMessage(HttpSession session) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		MemberVo sessionUser = (MemberVo) session.getAttribute("sessionUser");
		int no = sessionUser.getMember_no();
		int count = memberServiceJs.newMessageCount(no);
		
		if(count == 0) {
			data.put("result", "notMessage");
			return data;
		} else {
			data.put("result", "newMessage");
			data.put("count", count);
			return data;
		}
		
	}
	
	@ResponseBody
	@RequestMapping("checkNick")
	public HashMap<String, Object> checkNick(String nick,MessageVo messageVo) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		MemberVo getNickInfo = memberServiceJs.getMemberNick(nick);
		
		if(getNickInfo == null) {
			data.put("result", "notNick");
			return data;
		} else {
			int receiveNo = getNickInfo.getMember_no();
			messageVo.setReceive_no(receiveNo);
			data.put("result", "success");
			return data;
		}
		
	}
}
