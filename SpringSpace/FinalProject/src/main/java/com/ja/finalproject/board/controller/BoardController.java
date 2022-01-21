package com.ja.finalproject.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ja.finalproject.board.service.BoardService;
import com.ja.finalproject.vo.BoardImageVO;
import com.ja.finalproject.vo.BoardLikeVO;
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
	// 파일 업로드jsp부분에서 multiple 설정을 해줬으므로 배열(MultipartFile[])로 받음
	public String writeContentProcess(BoardVO param, MultipartFile[] uploadFiles, HttpSession session) {
		System.out.println("시스템 로그] 글쓰기 프로세스 실행");
		
		ArrayList<BoardImageVO> boardImageVOList = new ArrayList<>();
		
		String uploadFolder = "C:/uploadfolder/";
		
		// 파일 업로드
		if(uploadFiles != null) {
			for(MultipartFile uploadFile : uploadFiles) {
				// 업로드된 파일이 없어도 꼭 한 번은 루핑 돌기 때문에 isEmpty로 체크
				if(uploadFile.isEmpty()) {
					continue;
				}
				
				// 날짜 별 폴더 생성 2022/01/19
				Date today = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/"); 
				String folderPath= sdf.format(today);
				
				// file뿐만이 아닌 folder까지 컨트롤, folder도 file임
				// C:/uploadfolder/2022/01/19/
				File todayFolder = new File(uploadFolder + folderPath);
				
				if(!todayFolder.exists()) {
					// path 상위에서부터 없는 폴더 생성
					todayFolder.mkdirs();
				}
				
				// 중복되지 않게 저장해야 함(덮어씀 방지)
				// 방법 : 랜덤  + 시간
				String fileName = "";
				
				// universally unique identifier
				UUID uuid = UUID.randomUUID();				
				fileName += uuid.toString();
				
				long currentTime = System.currentTimeMillis();
				fileName += "_" + currentTime;
				
				// 확장자 추가
				// getOriginalFilename : 업로드한 쪽에서 설정한 파일명				
				String originalFileName = uploadFile.getOriginalFilename();
				String ext = originalFileName.substring(
						originalFileName.lastIndexOf("."));
				fileName += ext;
				
				try {
					// transferTo(File dest) : dest로 파일을 receive
					uploadFile.transferTo(new File(uploadFolder +
							folderPath + fileName));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// 서비스에 보내기 위한 데이터 구성
				BoardImageVO boardImageVO = new BoardImageVO();
				boardImageVO.setImage_url(folderPath + fileName);
				boardImageVO.setImage_original_filename(originalFileName);
				
				boardImageVOList.add(boardImageVO);
			}
		}
		
		
		// 파라미터로 title, content 2개 값 + session에서 member_no 받아와서 param에 넣음
		// 총 3개 값 세팅
		MemberVO sessionUser = (MemberVO) session.getAttribute("sessionUser");
		int memberNo = sessionUser.getMember_no();
		param.setMember_no(memberNo);
		
		// Service(class) -> Mapper(interface, XML) -> INSERT
		boardService.writeContent(param, boardImageVOList);
		
		return "redirect:./mainPage";
	}
	
	@RequestMapping("readContentPage")
	public String readContentPage(int board_no, Model model, HttpSession session) {
		boardService.increaseReadCount(board_no);
		
		HashMap<String, Object> map = boardService.getBoard(board_no, true);
		
		model.addAttribute("data", map);
		
		// 게시글의 총 좋아요 수
		int totalLikeCount = boardService.getTotalLikeCount(board_no);
		model.addAttribute("totalLikeCount", totalLikeCount);
		
		// 로그인인한 회원의 좋아요 여부 확인
		MemberVO sessionUser = (MemberVO) session.getAttribute("sessionUser");
		if(sessionUser != null) {
			BoardLikeVO boardLikeVO = new BoardLikeVO();
			boardLikeVO.setMember_no(sessionUser.getMember_no());
			boardLikeVO.setBoard_no(board_no);
			
			int myLikeCount = boardService.getMyLikeCount(boardLikeVO);
			
			model.addAttribute("myLikeCount", myLikeCount);
		}
		
		
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
	
	@RequestMapping("likeProcess")
	public String likeProcess(BoardLikeVO param, HttpSession session) {
		// 행위자 정보는 꼭 세션에서 가져올 것
		MemberVO sessionUser = (MemberVO) session.getAttribute("sessionUser");
		int memberNo = sessionUser.getMember_no();
		param.setMember_no(memberNo);
		
		boardService.doLike(param);
		
		return "redirect:./readContentPage?board_no=" + param.getBoard_no();
	}
}
