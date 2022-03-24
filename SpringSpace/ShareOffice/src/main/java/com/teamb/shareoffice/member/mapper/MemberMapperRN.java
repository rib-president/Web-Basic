package com.teamb.shareoffice.member.mapper;

import com.teamb.shareoffice.vo.MemberVo;

public interface MemberMapperRN {
	
	public MemberVo selectMemberById(String member_id);
	public void insertMember(MemberVo vo);
}
