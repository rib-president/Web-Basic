package com.teamb.shareoffice.guest.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamb.shareoffice.commons.KakaoRestAPI;
import com.teamb.shareoffice.guest.service.GuestServiceB;
import com.teamb.shareoffice.guest.service.GuestServiceRN;
import com.teamb.shareoffice.member.service.MemberServiceRN;
import com.teamb.shareoffice.vo.BusinessDayVo;
import com.teamb.shareoffice.vo.KakaopayVo;
import com.teamb.shareoffice.vo.MemberVo;
import com.teamb.shareoffice.vo.OrderVo;
import com.teamb.shareoffice.vo.RentalVo;

@Controller
@RequestMapping("/guest/*")
public class GuestControllerRN {
	
	@Autowired
	private MemberServiceRN memberService;
	
	@Autowired
	private GuestServiceB guestServiceB;
	
	@Autowired
	private GuestServiceRN guestServiceRN;
	
	@RequestMapping("kakaoPayApproval")
	public String kakaoPayApproval(String pg_token, HttpSession session, Model model) {
		String kakaoKey = memberService.getKakaoKey();
	
		KakaopayVo vo = (KakaopayVo) session.getAttribute("kakaopayVo");
		
		KakaoRestAPI kakao = new KakaoRestAPI();
		Map<String, Object> result = kakao.payApprove(pg_token, vo, session, kakaoKey);	
		
		model.addAttribute("response_code", result.get("response_code"));
		session.removeAttribute("kakaopayVo");
		return "guest/payDone";
	}
	
	@RequestMapping("kakaoPayCancel")
	public String kakaoPayCancel(HttpSession session) {
		session.removeAttribute("kakaopayVo");
		
		return "guest/payCancel";
	}
	
	@RequestMapping("kakaoPayFail")
	public String kakaoPayFail(HttpSession session) {
		session.removeAttribute("kakaopayVo");
		
		return "guest/payFail";
	}
	
	@RequestMapping("orderProcess")
	public String paymentProcess(Model model, HttpSession session, OrderVo orderVo, Date [] rental_date) {
		
		orderVo.setMember_no(((MemberVo) session.getAttribute("sessionUser")).getMember_no());
		
		String[] weekList = {"토", "일", "월", "화", "수", "목", "금"};
		
		ArrayList<RentalVo> rentalVoList = new ArrayList<>();
		for(Date rentalDay : rental_date) {
			RentalVo rentalVo = new RentalVo();
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(rentalDay);
			
			String day = weekList[calendar.get(Calendar.DAY_OF_WEEK)];
			
			BusinessDayVo businessDayVo = new BusinessDayVo();
			
			businessDayVo.setOffice_no(orderVo.getOffice_no());
			
			businessDayVo.setBusiness_day(day);
			
			rentalVo.setRental_date(rentalDay);
			rentalVo.setRental_price(guestServiceB.getPriceAndBusunessTime(businessDayVo).getBusiness_day_price());
			
			rentalVoList.add(rentalVo);
		}
		
		guestServiceRN.order(orderVo, rentalVoList);
		
		return "redirect:../guest/officeRentalDetailPage?office_no=" + orderVo.getOffice_no();
	}	
	
	@RequestMapping("officeRentalDetailPage")
	public String officeRentalDetailPage(int office_no) {
		
		return "guest/officeRentalDetailPage";
	}
	
}
