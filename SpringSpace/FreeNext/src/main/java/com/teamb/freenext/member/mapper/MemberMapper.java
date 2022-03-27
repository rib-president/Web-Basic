package com.teamb.freenext.member.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.teamb.freenext.vo.*;


@Mapper
public interface MemberMapper {
	// 회원정보 가져오기
	public MemberVo selectMemberByNo(int member_no);
	
	//insert MemberVo
	public void insertMember(MemberVo vo);
	//get last Pk
	public int getLastPK();
	
	////회원가입////
	//회원 중복확인
	public int getCountDuplicationMember(MemberVo vo);

	//MemberCustomer table insert
	public void insertMemberCustomerInfo(MemberCustomerVo vo);
	//CustomerJob table insert
	public void insertCustomerJob(CustomerJobVo vo);
	//CustomerLocal table insert
	public void insertCustomerLocal(CustomerLocalVo vo);
	//메일 인증 관련
	public void insertMailAuth(MailAuthVo vo);
	public void updateMailAuthComplete(String authKey);

	// 아이디로 멤버 찾기
	public MemberVo selectMemberById(String member_id);
	
	// 카카오 로그인용 키
	public String selectJSKey();
	
	//ID중복확인
	public int getCountById(String member_id);	

	//로그인
	public MemberVo loginByIdAndPw(MemberVo vo);
	
	//메일인증 확인
	public int checkMailAuthByMemberNo(int member_no);

	// 비밀번호 변경
	public void updatePw(MemberVo memberVo);
	
	// 회원정보 수정
	public void updateMemberInfo(MemberVo memberVo);
	public void updateCustomerInfo(MemberCustomerVo customerVo);
	
	
	// 희망지역/직종 변경
	public int selectCustomerNo(int member_no);
	public void deleteDesiredJob(@Param("customer_no") int customer_no, @Param("job_no") int job_no);
	public void deleteDesiredJobAll(int customer_no);
	public void deleteDesiredLocal(@Param("customer_no") int customer_no, @Param("local_no") int local_no);
	public void deleteDesiredLocalAll(int customer_no);
	public void deleteJobAlarm(@Param("member_no") int member_no, @Param("job_no") int job_no);
	public void deleteJobAlarmAll(int member_no);
	public void deleteLocalAlarm(@Param("member_no") int member_no, @Param("local_no") int local_no);
	public void deleteLocalAlarmAll(int member_no);
	
	//ID찾기
	public MemberVo findIdByNameAndPhone(MemberVo vo);
	//찾은 ID 갯수
	public int getCountFindId(MemberVo vo);
	
	// Pw찾기 관련
	public MemberVo getMemberInfoByIdAndNameAndPhone(MemberVo vo);
	// 찾은 PW 갯수(예외처리 관련)
	public MemberVo findPwByIdAndNameAndPhone(MemberVo vo);
	//비밀번호 찾기시 임시비밀번호로 변경
	public void changeToTemporaryPw(MemberVo vo);
	
	//customer 정보
	public MemberCustomerVo getCustomerInfoByMemberNo(int member_no);	

	//직종, 희망지역 카테고리 리스트
	public ArrayList<JobCategoryVo> getJobCategoryList();
	public ArrayList<LocalCategoryVo> getLocalCategoryList();
	
	// 기업회원 쿼리
	//insert companyVo 
	public void insertBizMember(MemberCompanyVo vo);
	// bizId 찾기 
	public MemberVo getBizIdCheck(MemberVo vo);
	// bizPw 찾기
	public MemberVo getBizPwCheck(MemberVo vo);
	// 기업 new Pw
	public void bizNewPw(MemberVo vo);
		
}
