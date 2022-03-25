package com.teamb.shareoffice.guest.mapper;

import java.util.ArrayList;


import com.teamb.shareoffice.vo.BusinessDayVo;
import com.teamb.shareoffice.vo.FacilityCategoryVo;
import com.teamb.shareoffice.vo.HostVo;
import com.teamb.shareoffice.vo.ImageDetailVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;
import com.teamb.shareoffice.vo.OrderVo;
import com.teamb.shareoffice.vo.ReviewVo;

public interface GuestMapper_H {
    //등록승인된 오피스 최신순 리스트 
	public ArrayList<OfficeInfoVo> getLatestOfficeList ();
	//오피스 상세보기 페이지
	public OfficeInfoVo getOfficeByNo(int offfice_no);	
	//운영시간 및 가격 가져오기
	public ArrayList<BusinessDayVo> getBusinessDayPriceByNo(int office_no);
	//이미지 가져오기
	public ArrayList<ImageDetailVo> getImageDetailByNo(int office_no);
	//편의시설 가져오기
	public ArrayList<FacilityCategoryVo> getFacilityByNo(int office_no);
	
	//리뷰목록
	public ArrayList<ReviewVo>getReviewByOffiNo(int office_no);
	public OrderVo getOrderByNo(int order_no);
	
	//호스트 신청하기
	public void insertApplyHostInfo(HostVo hvo);
	//호스트 승인하기
	public void updateHostApprove(HostVo hvo);
	//호스트 신청현황 
	public HostVo getHostApproveCheck(int host_no);
	
	}	
	
