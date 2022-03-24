package com.teamb.shareoffice.guest.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.teamb.shareoffice.guest.service.GuestService_H;
import com.teamb.shareoffice.vo.HostVo;
import com.teamb.shareoffice.vo.MemberVo;

@Controller
@RequestMapping("/guest/*")
public class GuestController_H {
	
	@Autowired
	private GuestService_H guestService_H;
	
	
	@RequestMapping("officeListPage")
	public String officeList(Model model) {
		ArrayList<HashMap<String, Object>> officelist = guestService_H.getLatestOfficeList();
		
		model.addAttribute("officelist",officelist);
		
		return "guest/officeListPage";
	}
	@RequestMapping("officeDetailPage")
	public String officeDetailPage(int office_no,Model model) {
		HashMap<String, Object>map = guestService_H.getOfficeDetail(office_no);
		
		model.addAttribute("office",map);
		
		return "guest/officeDetailPage";
	}
	@RequestMapping("officeMapPage")
	public String officeMapPage() {
		return "guest/officeMapPage";
	}
	
	@RequestMapping("applyHostPage")
	public String applyHostPage() {
		return "guest/applyHostPage";
	}
	@RequestMapping("applyHostProcess")
	public String applyHostProcess (HostVo hvo,MultipartFile license_img) {
		
		
      String uploadFolder = "C:/freeNext/licenseImg/";
		
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
		
		return "redirect:./applyCheckPage";
	}
		
	@RequestMapping("applyCheckPage")
	public String applyCheckPage(Model model,
			@RequestParam(value = "host_no" , defaultValue = "5") int host_no) {
				
	    HashMap<String, Object> map = guestService_H.getHostApprove(host_no);
		
		model.addAttribute("host",map);
				
		return "guest/applyCheckPage";
	}
}
