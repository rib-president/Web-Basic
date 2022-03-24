package com.teamb.shareoffice.guest.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamb.shareoffice.guest.service.GuestServiceB;
import com.teamb.shareoffice.vo.BusinessDayVo;
import com.teamb.shareoffice.vo.OrderVo;

@Controller
@RequestMapping("/guest/*")
public class GuestControllerB {
	
	@Autowired
	private GuestServiceB guestServiceB;
	
	@RequestMapping("orderPage")
	public String orderPage(Model model) {
		
		HashMap<String, Object> officeInfo = guestServiceB.getOfiiceInfo();
		ArrayList<HashMap<String, Object>> officeBusinessDayInfo = guestServiceB.getBusinessDayInfo();
		
		model.addAttribute("officeInfo", officeInfo);
		model.addAttribute("officeBusinessDayInfo", officeBusinessDayInfo);
		
		return "./guest/orderPage";
	}
	
	@RequestMapping("paymentPage")
	public String paymentPage(OrderVo ovo, BusinessDayVo bdvo, Model model, Date [] rental_date, int [] rental_price) {
		
		//원래는 파라미터로 officeNo 받아와서 guestServiceB.getOfiiceInfo() 안에 넣어야함
		//(orderPage view쪽엔 hidden으로 미리 넘기는 코드 작성)
		HashMap<String, Object> officeInfo = guestServiceB.getOfiiceInfo();
		
		//예약날짜 형식 변경(DateFormat)
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일, E");
		ArrayList<String> formatRentalDateList = new ArrayList<String>();
		
		//해당 오피스의 businessDayVo 리스트 (OrderAndPaymentProcess로 넘기기 위한)
//		ArrayList<BusinessDayVo> businessDayVoList = new ArrayList<BusinessDayVo>();
		
		int totalPayment = 0;
		int officeNo = 1;
		
		bdvo.setOffice_no(officeNo);
		
		if(rental_date != null) {
			for(int i=0; i<rental_date.length; i++) {
				String formatDate = simpleDateFormat.format(rental_date[i]);
				
				System.out.println("컨트롤러 : " + formatDate);
				formatRentalDateList.add(formatDate);
				
				String businessDay = formatDate.substring(15);
				System.out.println("컨트롤러 : " + businessDay);
				
				bdvo.setBusiness_day(businessDay);
				
				BusinessDayVo businessDayVo = guestServiceB.getPriceAndBusunessTime(bdvo);
				
//				businessDayVoList.add(businessDayVo);
				
				totalPayment += businessDayVo.getBusiness_day_price();
			}
		}
		
		
		model.addAttribute("officeInfo", officeInfo); // 오피스정보
		model.addAttribute("ovo", ovo); 
		model.addAttribute("formatRentalDateList", formatRentalDateList); //포맷된 예약날짜 리스트
		model.addAttribute("totalPayment", totalPayment); // 총결제금액
		model.addAttribute("rental_date", rental_date);
//		model.addAttribute("businessDayVoList", businessDayVoList);  // businessDayVo 리스트 (OrderAndPaymentProcess로 넘기기 위한)
		
		
		return "./guest/paymentPage";
	}
	
	@RequestMapping("orderAndPaymentProcess")
	public String orderAndPaymentProcess(OrderVo ovo, Date [] rental_date, int [] rental_price) {
		
		System.out.println("예약인원 : " + ovo.getOrder_personnel());
		
		for(int i=0; i<rental_date.length; i++) {
			System.out.println("rental_date : " + rental_date);
//			System.out.println("rental_price : " + rental_price);
		}
		
		return "./guest/rentalCompletePage";
	}
	
	

}
