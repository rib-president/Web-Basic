package com.teamb.shareoffice.host.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.shareoffice.host.mapper.HostMapper;
import com.teamb.shareoffice.vo.ImageDetailVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;

@Service
public class HostService {
	
	@Autowired
	private HostMapper hostMapper;
	
	
	public void registerOffice(OfficeInfoVo ovo, ArrayList<ImageDetailVo> imageDetailVoList) {
		
		hostMapper.insertOffice(ovo);
		int officeInfoNo = hostMapper.getLastPK();
		
		ovo.setOffice_no(officeInfoNo);
		hostMapper.insertOffice(ovo);
		
		for(ImageDetailVo imageDetailVo : imageDetailVoList) {
			
			imageDetailVo.setOffice_no(officeInfoNo);
			hostMapper.registerImage(imageDetailVo);
		}
		
		
		
	}

}
