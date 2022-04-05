package com.teamb.shareoffice.guest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.shareoffice.guest.mapper.GuestMapperB;
import com.teamb.shareoffice.vo.OrderVo;
import com.teamb.shareoffice.vo.RentalVo;

@Service
public class GuestServiceRN {

	@Autowired
	private GuestMapperB guestMapperB;
	
	public void order(OrderVo orderVo, ArrayList<RentalVo> rentalVoList) {
		
		guestMapperB.guestOrder(orderVo);
		
		int order_no = orderVo.getOrder_no();
		
		for(RentalVo rentalVo : rentalVoList) {
			rentalVo.setOrder_no(order_no);
			
			guestMapperB.officeRental(rentalVo);
		}
	}
}
