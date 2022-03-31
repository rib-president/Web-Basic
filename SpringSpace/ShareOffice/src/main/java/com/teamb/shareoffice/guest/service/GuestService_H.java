package com.teamb.shareoffice.guest.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.teamb.shareoffice.guest.mapper.GuestMapper_H;
import com.teamb.shareoffice.member.mapper.MemberMapperkt;
import com.teamb.shareoffice.vo.BusinessDayVo;
import com.teamb.shareoffice.vo.FacilityCategoryVo;
import com.teamb.shareoffice.vo.HostVo;
import com.teamb.shareoffice.vo.ImageDetailVo;
import com.teamb.shareoffice.vo.MemberVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;
import com.teamb.shareoffice.vo.OrderVo;
import com.teamb.shareoffice.vo.ReviewVo;

@Service
public class GuestService_H {

	
	
	@Autowired 
	private GuestMapper_H guestMapper_H;
	@Autowired
	private MemberMapperkt memberMapperkt;
	//오피스 기본 리스트
	public ArrayList<HashMap<String, Object>> getLatestOfficeList(){
		
		ArrayList<HashMap<String, Object>> officelist =  new ArrayList<HashMap<String, Object>>();
		ArrayList<OfficeInfoVo> officeVoList = guestMapper_H.getLatestOfficeList();
		
		
		for(OfficeInfoVo officeVo:officeVoList ) {
			
			ArrayList<BusinessDayVo> businessDayList = guestMapper_H.getBusinessDayPriceByNo(officeVo.getOffice_no()); 
		
			HashMap<String, Object> map = new HashMap<String, Object>();	
			//운영시간 및 가격 가져오기(수정 필요)
		
			
		    map.put("officeVo", officeVo);
		    map.put("businessDayList",businessDayList);
		
		  
		
		    officelist.add(map);
		}
		
		
		return officelist;
	}	
	//오피스 위치 전체 출력
    public ArrayList<OfficeInfoVo> getLocationList(String searchKeyword){
    	
    	ArrayList<OfficeInfoVo> list = guestMapper_H.getLocationList(searchKeyword);

    	return list;
    }
    //오피스 상세페이지
	public HashMap<String, Object> getOfficeDetail(int office_no){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		OfficeInfoVo officeVo = guestMapper_H.getOfficeByNo(office_no);
		ArrayList<BusinessDayVo> businessDayList = guestMapper_H.getBusinessDayPriceByNo(office_no); 
		
		ArrayList<ImageDetailVo> officeImageList = guestMapper_H.getImageDetailByNo(office_no);
		ArrayList<FacilityCategoryVo> facilityCategoryList = guestMapper_H.getFacilityByNo(office_no);
		
		
		map.put("officeVo",officeVo);
		map.put("facilityCategoryList",facilityCategoryList);
		map.put("officeImageList",officeImageList);
		map.put("businessDayList",businessDayList);
		
		return map;
	}
	
	public int getImageCount(int office_no) {
		return guestMapper_H.getImageCount(office_no);
	}
	// 오피스 이용후기 페이지
	public ArrayList<HashMap<String, Object>> reviewList(int office_no) {

		ArrayList<HashMap<String, Object>> orderList = new ArrayList<HashMap<String, Object>>();
		ArrayList<OrderVo> orderVoList = guestMapper_H.getOrderByNo(office_no);

		
		for (OrderVo orderVo : orderVoList) {
			
            int orderNo = orderVo.getOrder_no();
			ReviewVo reviewVo = guestMapper_H.getReviewByOrderNo(orderNo);		
			OfficeInfoVo officeInfoVo = guestMapper_H.getOfficeByNo(office_no);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("officeInfoVo", officeInfoVo);
			map.put("reviewVo",reviewVo);
			map.put("orderVo",orderVo);
			
			orderList.add(map);

		}
		
		return orderList;
	}

	
	
	public void applyHost(HostVo hvo) {
		
		guestMapper_H.insertApplyHostInfo(hvo);
		
	}
	//게스트가 호스트 신청한 목록 출력
	public ArrayList<HashMap<String, Object>> getHostApprove(int member_no ){
		
		ArrayList<HashMap<String, Object>> applyList =  new ArrayList<HashMap<String, Object>>();
		ArrayList<HostVo> hostVoList =  guestMapper_H.getHostApproveCheck(member_no);		
		
		for(HostVo hostVo:hostVoList) {
			int memberNo = hostVo.getMember_no();
			MemberVo memberVo = memberMapperkt.getMemberByNo(memberNo);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("hostVo",hostVo);
			
			applyList.add(map);
		}
		
			
		return applyList;
	}

}
