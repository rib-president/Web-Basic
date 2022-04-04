package com.teamb.shareoffice.guest.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import com.teamb.shareoffice.guest.service.GuestService_H;
import com.teamb.shareoffice.vo.HostVo;
import com.teamb.shareoffice.vo.MemberVo;


@Controller
@RequestMapping("/guest/*")
public class GuestController_H {
	
	@Autowired
	private GuestService_H guestService_H;
	
	private final String uploadFolder = "/shareOffice/licenseImg/";
	//private final String uploadFolder = "C:\shareOffice\licenseImg";
	
	@RequestMapping("mainPage")
	public String mainPage() {
		return "guest/mainPage";
	}
	
	@RequestMapping("officeListPage")
	public String officeList(Model model) {
		ArrayList<HashMap<String, Object>> officelist = guestService_H.getLatestOfficeList();
		
		model.addAttribute("officelist",officelist);
		
		return "guest/officeListPage";
	}
	@RequestMapping("officeDetailPage")
	public String officeDetailPage(int office_no,Model model) {
		HashMap<String, Object>map = guestService_H.getOfficeDetail(office_no);
		 ArrayList<HashMap<String, Object>> orderList = guestService_H.reviewList(office_no);
		
		 int imageCount = guestService_H.getImageCount(office_no);
		 model.addAttribute("imageCount",imageCount);
		 
	     model.addAttribute("orderList",orderList);
		
		 model.addAttribute("office",map);
		
		 return "guest/officeDetailPage";
	}
	@RequestMapping("officeReviewPage")
	public String officeReviewPage(Model model,int office_no) {
		
        ArrayList<HashMap<String, Object>> orderList = guestService_H.reviewList(office_no);

        
	    model.addAttribute("orderList",orderList);
		return "guest/officeReviewPage";
	}
		
	@RequestMapping("officeMapPage")
	public String officeMapPage(Model model) {
		
        ArrayList<HashMap<String, Object>> officelist = guestService_H.getLatestOfficeList();
		
		model.addAttribute("officelist",officelist);
		return "guest/officeMapPage";
	}
	
	@RequestMapping("applyHostPage")
	public String applyHostPage() {
		return "guest/applyHostPage";
	}
	@RequestMapping("applyHostProcess")
	public String applyHostProcess (HostVo hvo,MultipartFile license_img, HttpSession session) {
	
		System.out.println("파라미터 넘어오는지"+hvo.getHost_name());
		
		// setMember_no
		hvo.setMember_no(((MemberVo) session.getAttribute("sessionUser")).getMember_no());
		
		if(license_img != null) {
			
			//날짜별 폴더 생성 2022/01/19/
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
			String folderPath = sdf.format(today);
			
			File todayFolder = new File(uploadFolder + folderPath);
			
			if(!todayFolder.exists()) {
				todayFolder.mkdirs();
			}
			
			// 중복되지않게 저장
			String fileName = "";
			UUID uuid = UUID.randomUUID();
			fileName += uuid.toString();
			
			long currentTime = System.currentTimeMillis();
			fileName += "_" + currentTime;
			
			//확장자 추가
			String originalFileName = license_img.getOriginalFilename();
			String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
			fileName += ext;
			
			try {
				license_img.transferTo(new File(uploadFolder + folderPath + fileName));
			} catch(Exception e) {
				e.printStackTrace();
			}
		hvo.setHost_license_img(folderPath+fileName);
		   
		}

		
		guestService_H.applyHost(hvo);
		
		return "redirect:./applyCompletePage";
	}
	// 신청 완료시 페이지
	@RequestMapping("applyCompletePage")	
	public String applyCompletePage(HttpSession session) {
		
		MemberVo sessionUser = (MemberVo)session.getAttribute("sessionUser");
		int memberNo = sessionUser.getMember_no();
	
		return"guest/applyCompletePage";
	}
	//신청현황 보기
	@RequestMapping("applyCheckPage")
	public String applyCheckPage(Model model,HttpSession session) {
		
		MemberVo sessionUser = (MemberVo)session.getAttribute("sessionUser");
		int memberNo = sessionUser.getMember_no();
				
        ArrayList<HashMap<String, Object>> applyList =guestService_H.getHostApprove(memberNo);
		
        if(sessionUser !=null) {
		
			HostVo hostVo = new HostVo();
			hostVo.setMember_no(memberNo);
      
        
		model.addAttribute("applyList",applyList);
       }
				
		return "guest/applyCheckPage";
	}
}
