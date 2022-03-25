package com.teamb.shareoffice.host.mapper;

import java.util.ArrayList;

import com.teamb.shareoffice.vo.FacilityCategoryVo;
import com.teamb.shareoffice.vo.ImageDetailVo;
import com.teamb.shareoffice.vo.OfficeFacilityVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;

public interface HostMapper {
	
	// 오피스 등록관련
	public void insertOffice(OfficeInfoVo vo);
	
	public int getLastOfficeInfoPK();
	
	// 오피스 시설 카테고리 관련
	public void insertOfficeFacilityCategory(OfficeFacilityVo vo);
	
	public ArrayList<FacilityCategoryVo> getFacilityCategoryList();

	// 오피스 이미지 업로드 관련
	public void registerImage(ImageDetailVo vo);
	
	
}
