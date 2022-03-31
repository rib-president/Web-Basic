package com.teamb.shareoffice.admin.controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamb.shareoffice.admin.service.AdminService;
import com.teamb.shareoffice.vo.AdminVo;
import com.teamb.shareoffice.vo.MemberVo;

@Controller
@RequestMapping("/admin/*")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("loginAdmin")
	public String loginAdmin()
	{
		System.out.println("Log] �α��� ������ ����");
		
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
		System.out.println("Log] �α��� ����");
		
		AdminVo adminUser = adminService.loginAdmin(param);
		
		if(adminUser != null)
		{
			session.setAttribute("adminUser", adminUser);
			
			System.out.println("Log] �α��� ����");
			
			return "redirect:../admin/adminPage";
		}
		else
		{
			System.out.println("Log] �α��� ����");
			
			return "redirect:../admin/loginAdmin";
		}
			
	}
	
	@RequestMapping("adminPage")
	public String adminPage()
	{
		System.out.println("Log] ������ ������ ����");
		
		return "admin/adminPage";
	}
	
	@RequestMapping("guestManagement")
	public String guestManagement(Model model, String searchOption, String searchStr, @RequestParam(value="pageNum", defaultValue="1") int pageNum)
	{
		System.out.println("Log] �Խ�Ʈ ���� ������");
		
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
		System.out.println("Log] ȣ��Ʈ ���� ������");
		
		ArrayList<HashMap<String, Object>> hostList = adminService.hostManagement(searchOption, searchStr, pageNum);
		
		model.addAttribute("hostList", hostList);
		
		return "admin/hostManagement";
	}
	
	@RequestMapping("applyHostCheckList")
	public String applyHostCheckList(Model model)
	{
		System.out.println("Log] ȣ��Ʈ ��û�� ��� ������");
		
		ArrayList<HashMap<String, Object>> hostCheckList = adminService.applyHostCheckList();
		
		model.addAttribute("hostCheckList", hostCheckList);
		
		return "admin/applyHostCheckList";
	}
	
	@RequestMapping("hostApplyGuest")
	public String hostApplyGuest(int member_no, int host_no)
	{
		adminService.hostApplyGuest(member_no, host_no);
		
		return "redirect:../admin/applyHostCheckList";
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
		System.out.println("Log] ���ǽ� ���� ������");
		
		ArrayList<HashMap<String, Object>> officeList = adminService.getOfficeInformation(searchOption, searchStr, pageNum);
		
		model.addAttribute("officeList", officeList);
		
		return "admin/officeManagement";
	}
	
	@RequestMapping("adminOfficeDetail")
	public String adminOfficeDetail(Model model)
	{
		System.out.println("Log] ���ǽ� �� ������");
		
		ArrayList<HashMap<String, Object>> officeDetailList = adminService.officeDetailInformation();
		
		model.addAttribute("officeDetailList", officeDetailList);
		
		return "admin/adminOfficeDetail";
	}
	
	@RequestMapping("officeApply")
	public String officeApply(int office_no)
	{
		adminService.officeApply(office_no);
		
		return "redirect:../admin/adminOfficeDetail";
	}
	
	@RequestMapping("officeRefuse")
	public String officeRefuse(String office_no, String refuseReason)
	{	
		adminService.officeRefuse(office_no, refuseReason);
		
		return "redirect:../admin/adminOfficeDetail";
	}	
}
