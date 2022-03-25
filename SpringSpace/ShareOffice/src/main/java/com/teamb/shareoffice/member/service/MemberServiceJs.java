package com.teamb.shareoffice.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.shareoffice.member.mapper.MemberMapperJs;
import com.teamb.shareoffice.vo.MemberVo;
import com.teamb.shareoffice.vo.MessageVo;

@Service
public class MemberServiceJs {
	
	@Autowired
	private MemberMapperJs memberMapperJs;
	
	public ArrayList<HashMap<String, Object>> getMessageList() {
		
		ArrayList<HashMap<String, Object>> datalist = new ArrayList<HashMap<String,Object>>();
		
		ArrayList<MessageVo> messageVoList = memberMapperJs.getMessageList();
		
		for(MessageVo messageVo : messageVoList) {
			
			int memberNo = messageVo.getSender_no();
			
			MemberVo memberVo = memberMapperJs.getMemberByNo(memberNo);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("memberVo", memberVo);
			map.put("messageVo", messageVo);
			
			datalist.add(map);
		}
		
		return datalist;
	}
	
	public void writeMessage(MessageVo vo) {
		
		memberMapperJs.insertMessage(vo);
	}
	
}
