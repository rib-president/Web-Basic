package com.teamb.shareoffice.guest.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.teamb.shareoffice.guest.mapper.GuestMapper_H;
import com.teamb.shareoffice.vo.BusinessDayVo;
import com.teamb.shareoffice.vo.FacilityCategoryVo;
import com.teamb.shareoffice.vo.HostVo;
import com.teamb.shareoffice.vo.ImageDetailVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;

@Service
public class GuestService_H {

	
	
	@Autowired 
	private GuestMapper_H guestMapper_H;
	
	public ArrayList<HashMap<String, Object>> getLatestOfficeList(){
		
		ArrayList<HashMap<String, Object>> officelist =  new ArrayList<HashMap<String, Object>>();
		ArrayList<OfficeInfoVo> officeVoList = guestMapper_H.getLatestOfficeList();
		
		for(OfficeInfoVo officeVo:officeVoList ) {
		
			HashMap<String, Object> map = new HashMap<String, Object>();	
			//운영시간 및 가격 가져오기(수정 필요)
		//	BusinessDayVo businessDayVo = guestMapper_H.getBusinessDayPriceByNo(officeVo.getOffice_no()); 
			
		    map.put("officeVo", officeVo);
		//  map.put("businessDayVo",businessDayVo);
		  
		
		    officelist.add(map);
		}
		
		
		return officelist;
	}
	
	
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
	
	public void applyHost(HostVo hvo) {
		
		guestMapper_H.insertApplyHostInfo(hvo);
		
	}
	
	public HashMap<String, Object> getHostApprove(int host_no ){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		HostVo hostVo = guestMapper_H.getHostApproveCheck(host_no);		
		
		map.put("hostVo",hostVo);
		
		return map;
	}

}
