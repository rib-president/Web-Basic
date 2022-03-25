package com.teamb.shareoffice.host.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.shareoffice.host.mapper.HostMapper;
import com.teamb.shareoffice.vo.FacilityCategoryVo;
import com.teamb.shareoffice.vo.ImageDetailVo;
import com.teamb.shareoffice.vo.OfficeFacilityVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;

@Service
public class HostService {
	
	@Autowired
	private HostMapper hostMapper;
	
	
	public void registerOffice(OfficeInfoVo ovo, ArrayList<ImageDetailVo> imageDetailVoList, int [] facility_no) {
		
		int officeNo = hostMapper.getLastOfficeInfoPK();
		ovo.setOffice_no(officeNo);
		
		hostMapper.insertOffice(ovo);
		if(facility_no != null) {
			for(int fcNo : facility_no) {
				OfficeFacilityVo ofcVo = new OfficeFacilityVo();
				ofcVo.setOffice_no(officeNo);
				ofcVo.setFacility_no(fcNo);
				hostMapper.insertOfficeFacilityCategory(ofcVo);
			}
		}
		
		ovo.setOffice_no(officeNo);
		hostMapper.insertOffice(ovo);
		
		for(ImageDetailVo imageDetailVo : imageDetailVoList) {
			
			imageDetailVo.setOffice_no(officeNo);
			hostMapper.registerImage(imageDetailVo);
		}
		
	}
	
	public ArrayList<FacilityCategoryVo> getFacilityCategoryList(){
		return hostMapper.getFacilityCategoryList();
	}

}
