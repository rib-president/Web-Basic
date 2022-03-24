package com.teamb.shareoffice.host.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.teamb.shareoffice.host.service.HostService;
import com.teamb.shareoffice.vo.ImageDetailVo;
import com.teamb.shareoffice.vo.MemberVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;

@Controller
@RequestMapping("/host/*")
public class HostController {
	
	@Autowired
	private HostService hostService;
	
	
	@RequestMapping("registerOfficePage")
	public String registerOfficePage() {
		
		System.out.println("오피스등록 페이지 실행중입니다.");
		return "host/registerOfficePage";
	}
	
	@RequestMapping("registerOfficeProcess")
	public String registerOfficeProcess(OfficeInfoVo ovo, MemberVo mvo, HttpSession session, MultipartFile mainFiles, MultipartFile [] subFiles) {
		
		System.out.println("오피스등록 프로세스 실행");
		
		ArrayList<ImageDetailVo> imageDetailVoList = new ArrayList<ImageDetailVo>();
		
		String uploadFolder = "C:/uploadFolder/";
		
		if(subFiles != null) {
			for(MultipartFile uploadFile : subFiles) {
				if(uploadFile.isEmpty()) {
					continue;
				}
				
				//날짜별 폴더 생성
				Date today = new Date();
				SimpleDateFormat aaa = new SimpleDateFormat("yyyy/MM/dd");
				String folderPath = aaa.format(today);
				
				File todayFolder = new File(uploadFolder + folderPath);
				
				if(!todayFolder.exists()) {
					todayFolder.mkdirs();
				}
				
				//중복이름 피하기
				String fileName = "";
				UUID uuid = UUID.randomUUID();
				fileName += uuid.toString();
				
				long currentTime = System.currentTimeMillis();
				fileName += "_" + currentTime;
				
				//확장자 추가
				String originalFileName = uploadFile.getOriginalFilename();
				String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
				fileName += ext;
				
				try {
					uploadFile.transferTo(new File(uploadFolder + folderPath + "/" + fileName));
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				//Service로 보내기
				ImageDetailVo imageDetailVo = new ImageDetailVo();
				imageDetailVo.setImage_url(folderPath + "/" + fileName);
				imageDetailVoList.add(imageDetailVo);
				
				
			}
		}
		
		if(mainFiles != null && !mainFiles.isEmpty()) {
			
			//날짜별 폴더 생성
			Date today = new Date();
			SimpleDateFormat aaa = new SimpleDateFormat("yyyy/MM/dd");
			String folderPath = aaa.format(today);
			
			File todayFolder = new File(uploadFolder + folderPath);
			
			if(!todayFolder.exists()) {
				todayFolder.mkdirs();
			}
			
			//중복이름 피하기
			String fileName = "";
			UUID uuid = UUID.randomUUID();
			fileName += uuid.toString();
			
			long currentTime = System.currentTimeMillis();
			fileName += "_" + currentTime;
			
			//확장자 추가
			String originalFileName = mainFiles.getOriginalFilename();
			String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
			fileName += ext;
			
			try{
				mainFiles.transferTo(new File(uploadFolder + folderPath + "/" + fileName));
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			ovo.setOffice_thumbnail(folderPath + "/" + fileName);
			
		}
		
		//HostVo sessionHost = (HostVO)session.getAttribute("sessionUser");  
		//int memberNo = sessionHost.getMember_no();
		//ovo.setMember_no(memberNo);
		
		MemberVo sessionHost = (MemberVo)session.getAttribute("sessionHost");
		int memberNo = sessionHost.getMember_no();
		ovo.setMember_no(memberNo);
		
		hostService.registerOffice(ovo, imageDetailVoList);
		return "redirect:./mainPage";
	}

}
