package com.teamb.shareoffice.guest.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamb.shareoffice.commons.KakaoRestAPI;
import com.teamb.shareoffice.member.service.MemberServiceRN;
import com.teamb.shareoffice.vo.KakaopayVo;
import com.teamb.shareoffice.vo.MemberVo;

@RestController
@RequestMapping("/guest/*")
public class RestGuestControllerRN {

	@Autowired
	private MemberServiceRN memberService;
	
	@RequestMapping("payToKakao")
	public HashMap<String, Object> payToKakao(String item_name, String quantity, int total_amount, HttpSession session) {

		String kakaoKey = memberService.getKakaoKey();

		HashMap<String, Object> data = new HashMap<>();
		
		KakaoRestAPI kakao = new KakaoRestAPI();
		String partner_order_id = UUID.randomUUID().toString();
		String partner_user_id = ((MemberVo) session.getAttribute("sessionUser")).getMember_id();
		
		Map<String, Object> result = kakao.payReady(partner_order_id, partner_user_id, item_name, quantity, String.valueOf(total_amount), kakaoKey);				

		KakaopayVo vo = new KakaopayVo();
		
		vo.setTid((String) result.get("tid"));
		vo.setPartner_order_id(partner_order_id);
		vo.setTotal_amount(total_amount);		

		session.setAttribute("kakaopayVo", vo);

		data.put("next_redirect_pc_url", result.get("next_redirect_pc_url"));
		data.put("next_redirect_mobile_url", result.get("next_redirect_mobile_url"));
		data.put("tid", result.get("tid"));

		return data;
	}
}
