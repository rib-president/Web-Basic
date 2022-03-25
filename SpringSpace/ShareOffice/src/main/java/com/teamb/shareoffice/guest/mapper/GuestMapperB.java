package com.teamb.shareoffice.guest.mapper;

import java.util.ArrayList;

import com.teamb.shareoffice.vo.BusinessDayVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;
import com.teamb.shareoffice.vo.OrderVo;
import com.teamb.shareoffice.vo.RentalVo;

public interface GuestMapperB {
	
	public int getLastPK();
	public int getOrderNo();
	
	// 코드 합치기전엔 일단 파라미터 값 X
	// 오피스 상세보기페이지에서 파라미터로 officeNo를 받아와 오피스 정보 출력
	public OfficeInfoVo getOfficeInfoByOfficeNo(int office_no);
	public ArrayList<BusinessDayVo> getBusinessDayInfoByOfficeNo(int office_no);
	
	// order, rental 테이블 insert
	public void guestOrder(OrderVo ovo);
	public void officeRental(RentalVo rvo);
	
	// officeNo 와 businessDay로 가격 및 운영시간 받아오기
	public BusinessDayVo getPriceAndBusinessTimeByDay(BusinessDayVo bdvo);

}
