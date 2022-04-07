package com.teamb.shareoffice.host.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.teamb.shareoffice.vo.OfficeInfoVo;
import com.teamb.shareoffice.vo.OrderVo;
import com.teamb.shareoffice.vo.RentalVo;

public interface HostMapperRN {

	public ArrayList<HashMap<String, Object>> selectOfficeOrderRental(@Param("host_member_no") int host_member_no, @Param("rental_date") String rental_date);
	public HashMap<String, Object> selectOfficeOrder(int order_no);
	public ArrayList<RentalVo> selectRentalList(int order_no);
	public OrderVo selectOrderByRentalNo(int rental_no);
	
	public void updateRentalStatus(@Param("rental_no") int rental_no, @Param("rental_status") String rental_status);
	
	public RentalVo selectRental(int rental_no);
	
	public ArrayList<HashMap<String, Object>> selectOrderMember(@Param("category") String category, @Param("searchKeyword") String searchKeyword);
	public OfficeInfoVo selectOfficeByOrderNo(int order_no);
	public ArrayList<RentalVo> selectRentalByOrderNo(@Param("order_no") int order_no, @Param("onlyCancel") boolean onlyCancel);
	
	public ArrayList<RentalVo> selectMonthRental(@Param("member_no") int member_no, @Param("startDay") String startDay, @Param("endDay") String endDay);
	
	// 통계/대시보드
	// 오피스별 예약비율
	public ArrayList<HashMap<String, String>> selectRentalProportion(int member_no);
} 
