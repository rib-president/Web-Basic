package com.teamb.freenext.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.freenext.admin.mapper.AdminMapper;
import com.teamb.freenext.biz.service.BizService;
import com.teamb.freenext.vo.AdminVo;
import com.teamb.freenext.vo.MemberCompanyVo;
import com.teamb.freenext.vo.MemberCustomerVo;
import com.teamb.freenext.vo.MemberVo;

@Service
public class AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private BizService bizService;
	
	public AdminVo adminLogin(AdminVo vo) {
		
		AdminVo result = adminMapper.getAdminByIdAndPw(vo);
		
		return result;
	}
	
	
	public ArrayList<MemberVo> getMemberList(HashMap<String, Object> map){

		return adminMapper.getMemberList(map);
		
	}	
	
	public HashMap<String, Object> getMember (int memberNo){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		MemberVo memberVo = adminMapper.getCommonMemberByNo(memberNo);
		//memberNo = memberVo.getMember_no();
		map.put("memberVo", memberVo);
		
		if(memberVo.getMember_type().equals("N")) {
			
			MemberCustomerVo memberCustomerVo = adminMapper.getMemberCustomerByNo(memberNo);
			//int memberCustomerNo = memberCustomerVo.getCustomer_no();
			map.put("memberCustomerVo", memberCustomerVo);
			map.put("customer_birth", memberCustomerVo.getCustomer_birth());
			map.put("memberCompanyVo", null);
			
		} else {
			MemberCompanyVo memberCompanyVo = adminMapper.getMemberCompanyByNo(memberNo);
			//int memberCompanyNo = memberCompanyVo.getCompany_no();
			map.put("memberCompanyVo", memberCompanyVo);
			map.put("customer_birth", null);
			
		}
		
		return map;
				
	}
	
	public void updateMemberN(MemberVo mvo, MemberCustomerVo cvo) {
		adminMapper.updateCommonMember(mvo);
		adminMapper.updateMemberCustomer(cvo);
		
	}
	
	public void updateMemberB(MemberVo mvo, MemberCompanyVo cvo) {
		adminMapper.updateCommonMember(mvo);
		adminMapper.updateMemberCompany(cvo);
	}

	public int getTotalMemberNumber(HashMap<String, Object> map) {
				
		int result = adminMapper.getTotalNumber(map);
		
		return result;
	}
	
	public int getToalMemberTypeNumber(HashMap<String, Object> map, String member_type) {
		
		map.put("member_type", member_type);
		
		int result = adminMapper.getTotalMemberTypeNumber(map);
		
		return result;
	}
	
	public int getCompanyNumber() {
		
		int result = adminMapper.getTotalCompany();
		
		return result;
	}
	
	public MemberCompanyVo getCompanyVo(int member_no) {
		return adminMapper.selectCompanyVoByMemberNo(member_no);
	}
	
	// 통계
	// 회원 비율
	public HashMap<String, Object> getMemberProportion() {
		ArrayList<HashMap<String, String>> memberTypeCountList = adminMapper.selectAllMemberType();
		int totalMemberCount = memberTypeCountList.stream().mapToInt(a -> Integer.valueOf(a.get("cnt"))).sum();
		
		HashMap<String, Object> resultMap = new HashMap<>();
		
		for(HashMap<String, String> memberTypeCountMap : memberTypeCountList) {
			double proportion = (Math.round((Integer.valueOf(memberTypeCountMap.get("cnt")) / (totalMemberCount*1.0)) * 100))/10.0;
			if(memberTypeCountMap.get("member_type").equals("N")) {
				resultMap.put("normalProportion", proportion);
			} else {
				resultMap.put("bizProportion", proportion);
			}
		}
		return resultMap;
	}
	
	// 일별 회원가입(최근 일주일)
	public ArrayList<HashMap<String, Object>> getMemberCountDuringWeek() {
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<>();
		
		ArrayList<String> weekList = bizService.getWeekList();
		
		ArrayList<HashMap<String, String>> joinDateDuringWeekList = adminMapper.selectJoinDateDuringWeek(weekList.get(0), weekList.get(6));
		List<String> scrapDateList = joinDateDuringWeekList.stream().map(e -> e.get("joindate")).collect(Collectors.toList());

		for(String week : weekList) {
			HashMap<String, Object> map = new HashMap<>();
			
			if(scrapDateList.contains(week)) {
				for(HashMap<String, String> memberCountMap : joinDateDuringWeekList) {
					if(memberCountMap.get("joinDate").equals(week)) {
						map.put("day", week);
						map.put("cnt", memberCountMap.get("cnt"));
						
						resultList.add(map);
						break;	
					}					
				}				
			} else {
				map.put("day", week);
				map.put("cnt", 0);
				
				resultList.add(map);
			}
		}
				
		return resultList;
	}
	
	// 일별 프로젝트 등록/스크래핑 수(최근 일주일)
	
	// 개별등록/스크래핑 비율
	
	// 잡 카테고리별 프로젝트 비율
	
	// 누적 광고수익
	
	// 일별 등록 광고(최근 일주일)
}
