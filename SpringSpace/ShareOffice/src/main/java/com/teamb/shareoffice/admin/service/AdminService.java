package com.teamb.shareoffice.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.shareoffice.admin.mapper.AdminMapper;
import com.teamb.shareoffice.vo.AdminVo;
import com.teamb.shareoffice.vo.HostVo;
import com.teamb.shareoffice.vo.MemberVo;

@Service
public class AdminService 
{
	@Autowired
	private AdminMapper adminMapper;
	
	public AdminVo loginAdmin(AdminVo vo)
	{
		AdminVo result = adminMapper.getAdminPw(vo);
		
		return result;
	}
	
	public ArrayList<HashMap<String, Object>> guestManagement(String searchOption, String searchStr, int pageNum)
	{
		ArrayList<HashMap<String, Object>> guestList = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<MemberVo> memberVoList = adminMapper.getGuestInformation(searchOption, searchStr, pageNum);
			
		for(MemberVo memberVo : memberVoList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberVo", memberVo);
			
			guestList.add(map);
		}
		
		return guestList;
	}
	
	public ArrayList<HashMap<String, Object>> hostManagement()
	{
		ArrayList<HashMap<String, Object>> hostList = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<HostVo> hostVoList = adminMapper.getHostInformation();
		
		for(HostVo hostVo : hostVoList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("hostVo", hostVo);
			
			hostList.add(map);
		}
		
		return hostList;
	}
	
	public void deleteGuest(int member_no)
	{
		adminMapper.deleteGuest(member_no);
	}

}
