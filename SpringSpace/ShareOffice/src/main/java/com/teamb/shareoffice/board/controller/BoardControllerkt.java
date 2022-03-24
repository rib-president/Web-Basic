package com.teamb.shareoffice.board.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamb.shareoffice.board.service.BoardServicekt;
import com.teamb.shareoffice.vo.FreeBoardCommentVo;
import com.teamb.shareoffice.vo.FreeBoardVo;
import com.teamb.shareoffice.vo.MemberVo;

@Controller
@RequestMapping("/board/*")
public class BoardControllerkt {

	@Autowired
	private BoardServicekt boardServicekt;
	
	@RequestMapping("freeBoardPage")
	public String freeBoardPage(Model model,
			@RequestParam(value = "pageNum" , defaultValue = "1") int pageNum) {
		
		ArrayList<HashMap<String, Object>> freeBoardList = boardServicekt.getFreeBoardList(pageNum);
		
		int count = boardServicekt.getFreeBoardCount();
		
		int totalPageCount = (int)Math.ceil(count/10.0);
		
		int startPage = ((pageNum-1)/5)*5 + 1;
		int endPage = ((pageNum-1)/5 + 1)*(5);
		if(endPage > totalPageCount){
			endPage = totalPageCount;
		}
		
		model.addAttribute("count", count);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("freeBoardList", freeBoardList);
		
		return "board/freeBoardPage"; 
	}
	
	@RequestMapping("freeBoardWritePage")
	public String freeBoardWritePage() {
		
		return "board/freeBoardWritePage";
	}
	
	@RequestMapping("freeBoardWriteProcess")
	public String freeBoardWriteProcess(FreeBoardVo param, HttpSession session, MemberVo param2) {
		// 추후에 세션정보 있을시 수정 해야함
		param2.setMember_no(1);
		param2.setMember_nick("멤버1");
		int setNo = param2.getMember_no();
		session.setAttribute("MemberVo", setNo);
		String nick = param2.getMember_nick();
		session.setAttribute("MemberVoNick", nick);
		
		param.setMember_no(setNo);
		boardServicekt.insertFreeBoard(param);
		
		return "redirect:./freeBoardPage";
	}
	@RequestMapping("freeBoardReadPage")
	public String freeBoardReadPage(int freeboard_no, Model model) {
		boardServicekt.increaseFreeBoardReadCount(freeboard_no);
		
		HashMap<String, Object> map = boardServicekt.readFreeBoardRow(freeboard_no);
		model.addAttribute("data", map);	
		
		
		return "board/freeBoardReadPage";
	}
	
	@RequestMapping("deleteContentProcess")
	public String deleteContentProcess(int freeboard_no) {
		
		boardServicekt.deleteFreeBoardRow(freeboard_no);
		
		return "redirect:./freeBoardPage";
	}
	
	@RequestMapping("updateFreeBoardPage")
	public String updateFreeBoard(int freeboard_no, Model model) {
		HashMap<String, Object> map = boardServicekt.readFreeBoardRow(freeboard_no);
		model.addAttribute("data" , map);
		
		
		return "board/updateFreeBoardPage";
	}
	
	@RequestMapping("updateFreeBoardProcess")
	public String updateFreeBoardProcess(FreeBoardVo param) {
		
		boardServicekt.fixFreeBoardRow(param);
		
		return "redirect:./freeBoardReadPage?freeboard_no=" + param.getFreeboard_no();
	}
	
	@RequestMapping("freeBoardCommentWriteProcess")
	public String freeBoardCommentWriteProcess(FreeBoardCommentVo param, MemberVo param2, Model model) {
		// 추후에 세션정보 있을시 수정 해야함
		param2.setMember_no(1);
		int setNo = param2.getMember_no();
		param.setMember_no(setNo);
		
		//코멘트 등록
		boardServicekt.insertFreeBoardComment(param);
		//코멘트 값 가져오기
		ArrayList<HashMap<String, Object>> freeBoardCommentList = boardServicekt.getFreeBoardCommentList();
		model.addAttribute("freeBoardCommentList", freeBoardCommentList);
		
		return "redirect:./freeBoardReadPage?freeboard_no=" + param.getFreeboard_no();
	}
	
}
