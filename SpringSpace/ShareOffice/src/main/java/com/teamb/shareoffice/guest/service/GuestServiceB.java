package com.teamb.shareoffice.guest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
	
	
	public HashMap<String, Object> getOfiiceInfo() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		OfficeInfoVo officeInfoVo = guestMapperB.getOfficeInfoByOfficeNo();
		
		map.put("officeInfoVo", officeInfoVo);
		
		return map;
	}
	
	public ArrayList<HashMap<String, Object>> getBusinessDayInfo() {
		
		ArrayList<HashMap<String, Object>> businessDayVoList = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<BusinessDayVo> businessDayInfoList = guestMapperB.getBusinessDayInfoByOfficeNo();
		
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
	

	public void guestOrderAndOfficeRental (OrderVo ovo, Date [] rental_date, int [] rental_price) {
		
		int order_no = guestMapperB.getLastPK();
		
		guestMapperB.guestOrder(ovo);
		
		if(rental_date != null && rental_price != null) {
			
			RentalVo rvo = new RentalVo();
			
			for(int i=0; i<rental_date.length; i++) {
				
				rvo.setOrder_no(order_no);
				rvo.setRental_date(rental_date[i]);
				rvo.setRental_price(rental_price[i]);
				guestMapperB.officeRental(rvo);
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
