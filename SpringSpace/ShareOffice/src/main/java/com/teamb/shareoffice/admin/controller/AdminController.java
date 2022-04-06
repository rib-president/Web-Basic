package com.teamb.shareoffice.admin.controller;

import java.awt.Component;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.teamb.shareoffice.admin.service.AdminService;
import com.teamb.shareoffice.board.service.BoardServicekt;
import com.teamb.shareoffice.vo.AdminVo;
import com.teamb.shareoffice.vo.CouponVo;
import com.teamb.shareoffice.vo.MemberVo;

@Controller
@RequestMapping("/admin/*")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private BoardServicekt boardServicekt;
	
	@RequestMapping("loginAdmin")
	public String loginAdmin()
	{
		
		return "admin/loginAdmin";
	}
	
	@RequestMapping("logoutAdmin")
	public String logoutProcess(HttpSession session) {
		
		session.removeAttribute("adminUser");
		
		return "redirect:../admin/loginAdmin";
	}	
	
	
	@RequestMapping("adminLoginProcess")
	public String adminLoginProcess(AdminVo param, HttpSession session)
	{	
		AdminVo adminUser = adminService.loginAdmin(param);
		
		if(adminUser != null)
		{
			session.setAttribute("adminUser", adminUser);
			
			return "redirect:../admin/adminPage";
		}
		else
		{
			return "redirect:../admin/loginAdmin";
		}
			
	}
	
	@RequestMapping("adminPage")
	public String adminPage()
	{	
		return "admin/adminPage";
	}
	
	@RequestMapping("guestManagement")
	public String guestManagement(Model model, String searchOption, String searchStr, @RequestParam(value="pageNum", defaultValue="1") int pageNum)
	{		
		ArrayList<HashMap<String, Object>> guestList = adminService.guestManagement(searchOption, searchStr, pageNum);
		
		model.addAttribute("guestList", guestList);
		
		return "admin/guestManagement";
	}
	
	@RequestMapping("deleteGuest")
	public String deleteGuest(int member_no)
	{
		adminService.deleteGuest(member_no);
		
		return "redirect:../admin/guestManagement";
	}
	
	@RequestMapping("hostManagement")
	public String hostManagement(Model model, String searchOption, String searchStr, @RequestParam(value="pageNum", defaultValue="1") int pageNum)
	{	
		ArrayList<HashMap<String, Object>> hostList = adminService.hostManagement(searchOption, searchStr, pageNum);
		
		model.addAttribute("hostList", hostList);
		
		return "admin/hostManagement";
	}
	
	@RequestMapping("hostApplyGuest")
	public String hostApplyGuest(int member_no, int host_no)
	{
		adminService.hostApplyGuest(member_no, host_no);
		
		return "redirect:../admin/hostManagement";
	}
	
	@RequestMapping("hostRefuseGuest")
	public String hostRefuseGuest(String host_no, String refuseReason, String member_no)
	{	
		if(member_no != null)
		{
			adminService.hostRefuseGuest(host_no, refuseReason, member_no);
		
			return "redirect:../admin/deleteOfficeByHostRefuse?member_no=" + member_no;
		}
		else
		{	
			adminService.hostRefuseGuest(host_no, refuseReason, member_no);
			
			return "redirect:../admin/hostManagement";
		}
	}
	
	@RequestMapping("deleteOfficeByHostRefuse")
	public String deleteOfficeByHostRefuse(int member_no)
	{
		adminService.deleteOfficeByHostRefuse(member_no);
		
		return "redirect:../admin/hostManagement";
	}
	
	@RequestMapping("officeManagement")
	public String officeManagement(Model model, String searchOption, String searchStr, @RequestParam(value="pageNum", defaultValue="1") int pageNum)
	{		
		ArrayList<HashMap<String, Object>> officeList = adminService.getOfficeInformation(searchOption, searchStr, pageNum);
		
		model.addAttribute("officeList", officeList);
		
		return "admin/officeManagement";
	}
	
	@RequestMapping("officeApply")
	public String officeApply(int office_no)
	{
		adminService.officeApply(office_no);
		
		return "redirect:../admin/officeManagement";
	}
	
	@RequestMapping("officeRefuse")
	public String officeRefuse(String office_no, String refuseReason)
	{	
		adminService.officeRefuse(office_no, refuseReason);
		
		return "redirect:../admin/officeManagement";
	}
	
	@RequestMapping("createCouponPage")
	public String createCouponPage() {
	
		return "admin/createCouponPage";
	}
	
	@RequestMapping("createdCouponListPage")
	public String createdCouponListPage(Model model) {
		
		
		model.addAttribute("CouponVo", boardServicekt.getCouponList(0)); 
		
		
		return "admin/createdCouponListPage";
		
	}		
		
	@RequestMapping("createCouponProcess") 
	public String createCouponProcess(CouponVo param, MultipartFile image, HttpSession session) {
		String uploadFolder = "C:/shareOffice/couponImage/"; 
			System.out.println("�뜝�럩逾졿쾬�꼶梨룟뜝�룞�삕占쎈턄占쎈뎨�뜝占�" + image.getOriginalFilename());
			if(!image.isEmpty()) {
			
			//�뜝�럡�뀏嶺뚯쉸裕놅옙占� �뜝�럥夷ⓨ뜝�럥�맠 �뜝�럡臾멨뜝�럡�뎽...
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/"); 
			String folderPath = sdf.format(today);
			
			File todayFolder = new File(uploadFolder + folderPath); 
			
			String imgName = "";
			
			
			if(!todayFolder.exists()) {
				
				todayFolder.mkdirs();
			}
			
			String oriImgName = image.getOriginalFilename();
	
			// random uuid + �뜝�럩寃긷뜝�럩�궨�뜝�럥六삥뤆�룊�삕 + �뜝�럩�꼪�뜝�럩�궋�뜝�럩�겱
			UUID uuid = UUID.randomUUID();
			uuid = UUID.randomUUID();
			imgName += (uuid.toString() + oriImgName.substring(oriImgName.lastIndexOf(".")));
			
			try {
				image.transferTo(new File(uploadFolder + folderPath + imgName));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			param.setCoupon_image(folderPath + imgName);
		
		}
		AdminVo adminVo = (AdminVo)session.getAttribute("AdminUser");
		if(adminVo != null) {
			param.setAdmin_no(adminVo.getAdmin_no());
		}
		boardServicekt.insertCoupon(param);	
		
		return "redirect:./createdCouponListPage";
	}
	
}
