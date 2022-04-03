package com.teamb.shareoffice.host.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamb.shareoffice.host.service.HostServiceRN;

@Controller
@RequestMapping("/host/*")
public class HostControllerRN {
	
	@Autowired
	private HostServiceRN hostService;
	
	@RequestMapping("rentalStatusPage")
	public String rentalStatusPage() {
		
		return "host/rentalStatusPage";
	}
	
	@RequestMapping("orderDetailPage")
	public String orderDetailPage(int order_no, Model model) {
		model.addAttribute("resultMap", hostService.getOrderDetailInfo(order_no));
		
		return "host/orderDetailPage";
	}
}
