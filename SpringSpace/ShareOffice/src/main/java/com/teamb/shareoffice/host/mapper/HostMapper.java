package com.teamb.shareoffice.host.mapper;

import com.teamb.shareoffice.vo.ImageDetailVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;

public interface HostMapper {
	
	// 오피스 등록관련
	public void insertOffice(OfficeInfoVo vo);
	
	public int getLastPK();

	// 오피스 이미지 업로드 관련
	public void registerImage(ImageDetailVo vo);
	
	
}
