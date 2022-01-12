package com.ja.finalproject.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.finalproject.vo.BoardVO;
import com.ja.finalproject.vo.MemberVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@RequestMapping("mainPage")
	public String mainPage() {
		System.out.println("시스템 로그] 메인 페이지 실행");
		
		return "board/mainPage";
	}
	
	@RequestMapping("writeContentPage")
	public String writeContentPage() {
		System.out.println("시스템 로그] 글쓰기 페이지 실행");
		
		return "board/writeContentPage";
	}
	
	@RequestMapping("writeContentProcess")
	public String writeContentProcess(BoardVO param, HttpSession session) {
		// 파라미터로 title, content 2개 값 + session에서 member_no 받아와서 param에 넣음
		// 총 3개 값 세팅
		MemberVO sessionUser = (MemberVO) session.getAttribute("sessionUser");
		int memberNo = sessionUser.getMember_no();
		param.setMember_no(memberNo);
		
		// Service(class) -> Mapper(interface, XML) -> INSERT 
		
		return "redirect:./mainPage";
	}
}
