package com.teamb.shareoffice.admin.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.teamb.shareoffice.vo.AdminVo;
import com.teamb.shareoffice.vo.HostVo;
import com.teamb.shareoffice.vo.MemberVo;

public interface AdminMapper 
{
	public AdminVo getAdminPw(AdminVo vo);
	public ArrayList<MemberVo> getGuestInformation(@Param("searchOption") String searchOption, @Param("searchStr") String searchStr, @Param("pageNum") int pageNum);
	public ArrayList<HostVo> getHostInformation();
	
	public void deleteGuest(int member_no); 
}
