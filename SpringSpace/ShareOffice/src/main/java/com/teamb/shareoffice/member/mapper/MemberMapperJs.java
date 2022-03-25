package com.teamb.shareoffice.member.mapper;

import java.util.ArrayList;

import com.teamb.shareoffice.vo.MemberVo;
import com.teamb.shareoffice.vo.MessageVo;

public interface MemberMapperJs {

	public ArrayList<MessageVo> getMessageList();
	
	public MemberVo getMemberByNo(int no);
	
	public void insertMessage(MessageVo vo);
	
}
