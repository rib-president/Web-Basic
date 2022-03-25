package com.teamb.shareoffice.guest.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.shareoffice.guest.mapper.GuestMapperB;
import com.teamb.shareoffice.vo.BusinessDayVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;
import com.teamb.shareoffice.vo.OrderVo;
import com.teamb.shareoffice.vo.RentalVo;

@Service
public class GuestServiceB {
	
	@Autowired
	private GuestMapperB guestMapperB;
	
	
	public HashMap<String, Object> getOfiiceInfo(int office_no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		OfficeInfoVo officeInfoVo = guestMapperB.getOfficeInfoByOfficeNo(office_no);
		
		map.put("officeInfoVo", officeInfoVo);
		
		return map;
	}
	
	public ArrayList<HashMap<String, Object>> getBusinessDayInfo(int office_no) {
		
		ArrayList<HashMap<String, Object>> businessDayVoList = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<BusinessDayVo> businessDayInfoList = guestMapperB.getBusinessDayInfoByOfficeNo(office_no);
		
		for(BusinessDayVo businessDayVo : businessDayInfoList) {
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("businessDayVo", businessDayVo);
			
			businessDayVoList.add(map);
		}
		
		return businessDayVoList;
		
	}
	
	public BusinessDayVo getPriceAndBusunessTime(BusinessDayVo bdvo) {
		
		return guestMapperB.getPriceAndBusinessTimeByDay(bdvo);
		
	}
	

	public void guestOrderAndOfficeRental (OrderVo ovo, String [] rental_date, int [] rental_price) {
		
		//예약날짜 타입 변경(Parse : String -> Date)
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
		
		guestMapperB.guestOrder(ovo);
		
		int order_no = guestMapperB.getOrderNo();
		System.out.println(order_no);
		
		if(rental_date != null && rental_price != null) {
			for(int i=0; i<rental_date.length; i++) {
				
				RentalVo rvo = new RentalVo();
				rvo.setOrder_no(order_no);
				try {
					rvo.setRental_date(sdf.parse(rental_date[i]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				rvo.setRental_price(rental_price[i]);
				guestMapperB.officeRental(rvo);
			}
			
		}
	
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
