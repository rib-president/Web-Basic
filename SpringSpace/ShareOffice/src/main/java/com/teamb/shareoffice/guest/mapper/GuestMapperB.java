package com.teamb.shareoffice.guest.mapper;

import java.util.ArrayList;

import com.teamb.shareoffice.vo.BusinessDayVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;
import com.teamb.shareoffice.vo.OrderVo;
import com.teamb.shareoffice.vo.RentalVo;
import com.teamb.shareoffice.vo.ReviewVo;

public interface GuestMapperB {
	
	// 코드 합치기전엔 일단 파라미터 값 X
	// 오피스 상세보기페이지에서 파라미터로 officeNo를 받아와 오피스 정보 출력
	public OfficeInfoVo getOfficeInfoByOfficeNo(int office_no);
	public ArrayList<BusinessDayVo> getBusinessDayInfoByOfficeNo(int office_no);
	
	// order, rental 테이블 insert
	public void guestOrder(OrderVo ovo);
	public void officeRental(RentalVo rvo);
	
	//캘린더 관련
	public ArrayList<RentalVo> getRentalListByOfficeNo(int office_no);
	
	// officeNo 와 businessDay로 가격 및 운영시간 받아오기
	public BusinessDayVo getPriceAndBusinessTimeByDay(BusinessDayVo bdvo);
	
	//게스트의 예약현황 페이지 관련
	public ArrayList<OrderVo> getOrderListByMemberNo(int member_no);
	public ArrayList<RentalVo> getRentalListByOrderNo(int order_no);
	
	//리뷰관련
	public void writeReview(ReviewVo rvo);
	public int reviewExistCheck(int order_no);
	
	

}
