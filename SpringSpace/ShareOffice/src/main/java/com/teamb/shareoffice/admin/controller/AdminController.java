package com.teamb.shareoffice.admin.controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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
		System.out.println("Log] 로그인 페이지 진입");
		
		return "admin/loginAdmin";
	}
	
	
	@RequestMapping("adminLoginProcess")
	public String adminLoginProcess(AdminVo param, HttpSession session)
	{
		System.out.println("Log] 로그인 진행");
		
		AdminVo adminUser = adminService.loginAdmin(param);
		
		if(adminUser != null)
		{
			session.setAttribute("adminUser", adminUser);
			
			System.out.println("Log] 로그인 성공");
			
			return "redirect:../admin/adminPage";
		}
		else
		{
			System.out.println("Log] 로그인 실패");
			
			return "redirect:../admin/loginAdmin";
		}
			
	}
	
	@RequestMapping("adminPage")
	public String adminPage()
	{
		System.out.println("Log] 관리자 페이지 진입");
		
		return "admin/adminPage";
	}
	
	@RequestMapping("guestManagement")
	public String guestManagement(Model model, String searchOption, String searchStr, @RequestParam(value="pageNum", defaultValue="1") int pageNum)
	{
		System.out.println("Log] 게스트 관리 페이지");
		
		ArrayList<HashMap<String, Object>> guestList = adminService.guestManagement(searchOption, searchStr, pageNum);
		
		model.addAttribute("guestList", guestList);
		
		return "admin/guestManagement";
	}
	
	@RequestMapping("hostManagement")
	public String hostManagement(Model model)
	{
		System.out.println("Log] 호스트 관리 페이지");
		
		ArrayList<HashMap<String, Object>> hostList = adminService.hostManagement();
		
		model.addAttribute("hostList", hostList);
		
		return "admin/hostManagement";
	}
	
	@RequestMapping("deleteGuest")
	public String deleteGuest(int member_no)
	{
		adminService.deleteGuest(member_no);
		
		return "redirect:../admin/guestManagement";
	}
	
	
	
}
