package com.teamb.shareoffice.host.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamb.shareoffice.host.service.HostService;

@RestController
@RequestMapping("/host/*")
public class RestHostController {
	
	@Autowired
	private HostService hostService;	
	
	@RequestMapping("getBusinessDayData")
	public HashMap<String, Object> getBusinessDayData(int office_no) {
		
		HashMap<String, Object> data = new HashMap<>();
		
		data.put("businessDayVoList", hostService.getBusinessDayInfo(office_no));
		
		return data;
	}
}
