package com.teamb.shareoffice.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamb.shareoffice.guest.service.GuestServiceB;
import com.teamb.shareoffice.guest.service.GuestService_H;
import com.teamb.shareoffice.vo.BusinessDayVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;


@RestController
@RequestMapping("/guest/*")
public class RestGuestController {
	
	@Autowired
	private GuestServiceB guestServiceB;
	
	
	@RequestMapping("getOfficeReservedDateAndBusinessDay")
	public HashMap<String, Object> getOfficeReservedDateAndBusinessDay(int office_no){
		HashMap<String, Object> responseData = new HashMap<String, Object>();
		
		responseData.put("officeBusinessDayInfo", guestServiceB.getBusinessDayInfo(office_no));
		responseData.put("officeRentalList", guestServiceB.getOfficeRentalList(office_no));
		
		return responseData;
	}
	
	
	@Autowired 
	private GuestService_H guestService_H;
	
	@RequestMapping("getLocationList")
	public HashMap<String, Object> getLocationList(String searchKeyword){
		HashMap<String, Object> locationData = new HashMap<String, Object>();
		
		ArrayList<OfficeInfoVo> locationList = guestService_H.getLocationList(searchKeyword);

		locationData.put("result","success");
		locationData.put("locationList",locationList);
		
		return locationData;
		
	}
	
	
	@RequestMapping("getDayPrice")
	public HashMap<String, Object> getDayPrice(BusinessDayVo bdvo){
		HashMap<String, Object> responseData = new HashMap<String, Object>();
		
		responseData.put("businessDayVo", guestServiceB.getPriceAndBusiunessTime(bdvo));
		
		return responseData;
	}
	
	
	

}
