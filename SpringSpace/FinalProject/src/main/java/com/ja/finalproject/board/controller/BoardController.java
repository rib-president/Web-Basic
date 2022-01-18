package com.ja.finalproject.board.controller;

import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ja.finalproject.board.service.BoardService;
import com.ja.finalproject.vo.BoardVO;
import com.ja.finalproject.vo.MemberVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("mainPage")
	public String mainPage(
			Model model,
			String searchOption,
			String searchWord, 
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {	// Model 객체 : request 저장공간과 같은 역할
		System.out.println("시스템 로그] 메인 페이지 실행");
		
		ArrayList<HashMap<String, Object>> dataList = boardService.getBoardList(searchOption, searchWord, pageNum);
		
		int count = boardService.getBoardCount(searchOption, searchWord);
		// 10미만의 게시글이 있는 마지막 페이지 개수까지 포함하기 위해 ceil(올림함수) 사용
		int totalPageCount = (int) Math.ceil(count / 10.0);	
		
		int startPage = ((pageNum-1)/5)*5 + 1;
		int endPage = ((pageNum-1)/5 + 1) * (5);
		
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		
		// 페이징 링크 검색 추가 옵션
		String additionalParam = "";

		// URL encoding -> 영어/숫자/특수문자 아닌 값이 존재할 때 처리
		if(searchOption != null) {
			try {
				searchOption = URLEncoder.encode(searchOption, "utf-8");
			} catch(Exception e) {
				e.printStackTrace();
			}
			additionalParam += "&searchOption=" + searchOption;
		}
		
		if(searchWord != null) {
			try {
				searchWord = URLEncoder.encode(searchWord, "utf-8");
			} catch(Exception e) {
				e.printStackTrace();
			}
			additionalParam += "&searchWord=" + searchWord;
		}
		
		
		model.addAttribute("additionalParam", additionalParam);

		// model.addAttribute("count", count); //	글 개수 출력할거면 쓸 것
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("dataList", dataList);	// request.setAttribute
		return "board/mainPage";
	}
	
	@RequestMapping("writeContentPage")
	public String writeContentPage() {
		System.out.println("시스템 로그] 글쓰기 페이지 실행");
		
		return "board/writeContentPage";
	}
	
	@RequestMapping("writeContentProcess")
	public String writeContentProcess(BoardVO param, HttpSession session) {
		System.out.println("시스템 로그] 글쓰기 프로세스 실행");
		
		// 파라미터로 title, content 2개 값 + session에서 member_no 받아와서 param에 넣음
		// 총 3개 값 세팅
		MemberVO sessionUser = (MemberVO) session.getAttribute("sessionUser");
		int memberNo = sessionUser.getMember_no();
		param.setMember_no(memberNo);
		
		// Service(class) -> Mapper(interface, XML) -> INSERT
		boardService.writeContent(param);
		
		return "redirect:./mainPage";
	}
	
	@RequestMapping("readContentPage")
	public String readContentPage(int board_no, Model model) {
		boardService.increaseReadCount(board_no);
		
		HashMap<String, Object> map = boardService.getBoard(board_no, true);
		
		model.addAttribute("data", map);
		
		return "board/readContentPage";
	}
	
	@RequestMapping("deleteContentProcess")
	public String deleteContentProcess(int board_no) {
		boardService.deleteBoard(board_no);
		
		return "redirect:./mainPage";
	}
	
	@RequestMapping("updateContentPage")
	public String updateContentPage(int board_no, Model model) {
		HashMap<String, Object> map = boardService.getBoard(board_no, false);
		
		model.addAttribute("data", map);
		
		return "board/updateContentPage";
	}
	
	@RequestMapping("updateContentProcess")
	public String updateContentProcess(BoardVO vo) {
		boardService.updateBoard(vo);
		
		return "redirect:./readContentPage?board_no=" + vo.getBoard_no();
	}
}
