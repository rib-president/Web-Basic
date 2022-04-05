package com.teamb.shareoffice.guest.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.shareoffice.guest.mapper.GuestMapperB;
import com.teamb.shareoffice.guest.mapper.GuestMapperRN;
import com.teamb.shareoffice.vo.OrderVo;
import com.teamb.shareoffice.vo.RentalVo;

@Service
public class GuestServiceRN {

	@Autowired
	private GuestMapperB guestMapperB;
	
	@Autowired
	private GuestMapperRN guestMapperRN;
	
	public void order(OrderVo orderVo, ArrayList<RentalVo> rentalVoList) {
		
		guestMapperB.guestOrder(orderVo);
		
		int order_no = orderVo.getOrder_no();
		
		for(RentalVo rentalVo : rentalVoList) {
			rentalVo.setOrder_no(order_no);
			
			guestMapperB.officeRental(rentalVo);
		}
	}
	
	public ArrayList<HashMap<String, Object>> getMemberCoupon(int member_no) {
		return guestMapperRN.selectMemberCoupon(member_no);
	}
	
	public void useCoupon(int allot_no) {
		guestMapperRN.useCoupon(allot_no);
	}
}
