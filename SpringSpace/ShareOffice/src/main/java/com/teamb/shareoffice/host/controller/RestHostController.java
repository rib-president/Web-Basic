package com.teamb.shareoffice.host.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamb.shareoffice.commons.KakaoRestAPI;
import com.teamb.shareoffice.host.service.HostService;
import com.teamb.shareoffice.host.service.HostServiceRN;
import com.teamb.shareoffice.member.service.MemberServiceRN;
import com.teamb.shareoffice.vo.MemberVo;
import com.teamb.shareoffice.vo.OrderVo;
import com.teamb.shareoffice.vo.RentalVo;

@RestController
@RequestMapping("/host/*")
public class RestHostController {
	
	@Autowired
	private HostServiceRN hostServiceRN;
	
	@Autowired
	private HostService hostService;
	
	@Autowired
	private MemberServiceRN memberService;
	
	@RequestMapping("getBusinessDayData")
	public HashMap<String, Object> getBusinessDayData(int office_no) {
		
		HashMap<String, Object> data = new HashMap<>();
		
		data.put("businessDayVoList", hostService.getBusinessDayInfo(office_no));
		
		return data;
	}
	
	@RequestMapping("getCalendarRentalList")
	public HashMap<String, Object> getCalendarRentalList(String rental_date, HttpSession session) {
		HashMap<String, Object> data = new HashMap<>();
		
		MemberVo sessionUser = (MemberVo) session.getAttribute("sessionUser");
		if(sessionUser != null && sessionUser.getMember_type().equals("H")) {
			data.put("result", "success");
			data.put("dataList", hostServiceRN.getCalendarRentalList(sessionUser.getMember_no(), rental_date));
		} else {
			data.put("result", "error");
			data.put("message", "호스트가 아닙니다.");
		}
		
		return data;
	}
	
	@RequestMapping("useRental")
	public HashMap<String, Object> useRental(int rental_no) {
		HashMap<String, Object> data = new HashMap<>();
		
		data.put("result", "success");
		hostServiceRN.modifyRentalStatus(rental_no, "U");
		
		return data;
	}
	
	@RequestMapping("cancelRental")
	public HashMap<String, Object> cancelRental(int rental_no) {
		HashMap<String, Object> data = new HashMap<>();
		
		OrderVo orderVo = hostServiceRN.getOrderByRentalNo(rental_no);
		
		RentalVo rentalVo = hostServiceRN.getRental(rental_no);
		
		KakaoRestAPI kakaoRestAPI = new KakaoRestAPI();
		
		Map<String, Object> resultMap = kakaoRestAPI.payCancel(orderVo.getOrder_tid(), String.valueOf(rentalVo.getRental_price()), memberService.getKakaoKey());
		
		if(resultMap.get("tid").toString().equals(orderVo.getOrder_tid())) {
			hostServiceRN.modifyRentalStatus(rental_no, "C");
			data.put("result", "success");
			
			hostServiceRN.modifyRentalStatus(rental_no, "C");
		} else {
			data.put("result", "error");
			data.put("message", "취소 실패");
		}				
		
		return data;
	}
	
	@RequestMapping("searchOrder")
	public HashMap<String, Object> searchOrder(String category, String searchKeyword, boolean onlyCancel) {
		HashMap<String, Object> data = new HashMap<>();
		
		data.put("dataList", hostServiceRN.getOrderList(category, searchKeyword, onlyCancel));		
		
		return data;
	}
	
	@RequestMapping("getMonthRental")
	public HashMap<String, Object> getMonthRental(String rental_date, HttpSession session) {
		HashMap<String, Object> data = new HashMap<>();
		
		data.put("monthRentalList", hostServiceRN.getMonthRental(((MemberVo) session.getAttribute("sessionUser")).getMember_no(), rental_date));
		
		return data;
	}
	
}
