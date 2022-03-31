package com.teamb.shareoffice.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.shareoffice.admin.mapper.AdminMapper;
import com.teamb.shareoffice.vo.AdminVo;
import com.teamb.shareoffice.vo.HostVo;
import com.teamb.shareoffice.vo.MemberVo;
import com.teamb.shareoffice.vo.OfficeInfoVo;

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
	
	public void deleteGuest(int member_no)
	{
		adminMapper.deleteGuest(member_no);
	}
	
	public ArrayList<HashMap<String, Object>> hostManagement(String searchOption, String searchStr, int pageNum)
	{
		ArrayList<HashMap<String, Object>> hostList = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<HostVo> hostVoList = adminMapper.getHostInformation(searchOption, searchStr, pageNum);
		
		for(HostVo hostVo : hostVoList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("hostVo", hostVo);
			
			hostList.add(map);
		}
		
		return hostList;
	}
	
	public ArrayList<HashMap<String, Object>> applyHostCheckList()
	{
		ArrayList<HashMap<String, Object>> getHostCheckList = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<HostVo> hostVoCheckList = adminMapper.getCheckApplyHostList();
	
		for(HostVo hostVo : hostVoCheckList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("checkHost", hostVo);
			
			getHostCheckList.add(map);
		}
		
		return getHostCheckList;
	}
	
	public void hostApplyGuest(int member_no, int host_no)
	{
		adminMapper.hostApplyGuest(host_no);
		adminMapper.updateMemberType(String.valueOf(member_no), "H");
	}

	
	public void hostRefuseGuest(String host_no, String refuseReason, String member_no)
	{
		System.out.println("멤버 번호 : " + member_no);
		adminMapper.hostRefuseGuest(host_no, refuseReason, member_no);
		if(member_no != null) {
			adminMapper.updateMemberType(member_no, "G");
			adminMapper.updateOfficeApprove(Integer.parseInt(member_no));
		}
		
	}

	public ArrayList<HashMap<String, Object>> getOfficeInformation(String searchOption, String searchStr, int pageNum)
	{
		ArrayList<HashMap<String, Object>> getOfficeList = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<OfficeInfoVo> getVoList = adminMapper.getOfficeInformation(searchOption, searchStr, pageNum);
		
		for(OfficeInfoVo officeInfoVo : getVoList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("getOffice", officeInfoVo);
			
			getOfficeList.add(map);
		}
		
		return getOfficeList;
	}
	
	public ArrayList<HashMap<String, Object>> officeDetailInformation()
	{
		ArrayList<HashMap<String, Object>> getOfficeDetail = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<OfficeInfoVo> officeVoList = adminMapper.officeDetail();
	
		for(OfficeInfoVo officeInfoVo : officeVoList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("getOfficeVo", officeInfoVo);
			
			getOfficeDetail.add(map);
		}
		
		return getOfficeDetail;
	}
	
	public void officeApply(int office_no)
	{
		adminMapper.officeApply(office_no);
	}
	
	public void officeRefuse(String office_no, String refuseReason)
	{
		adminMapper.officeRefuse(office_no, refuseReason);
	}
	
	public void deleteOfficeByHostRefuse(int member_no)
	{
		adminMapper.deleteOfficeByHostRefuse(member_no);
	}

}
	
