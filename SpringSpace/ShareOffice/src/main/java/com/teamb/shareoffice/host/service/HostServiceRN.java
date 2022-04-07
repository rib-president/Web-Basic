package com.teamb.shareoffice.host.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamb.shareoffice.guest.mapper.GuestMapperB;
import com.teamb.shareoffice.host.mapper.HostMapperRN;
import com.teamb.shareoffice.member.mapper.MemberMapperJs;
import com.teamb.shareoffice.vo.BusinessDayVo;
import com.teamb.shareoffice.vo.OrderVo;
import com.teamb.shareoffice.vo.RentalVo;

@Service
public class HostServiceRN {

	@Autowired
	private HostMapperRN hostMapper;
	
	@Autowired
	private MemberMapperJs memberMapper;
	
	@Autowired
	private GuestMapperB guestMapperB;
	
	public ArrayList<HashMap<String, Object>> getCalendarRentalList(int host_member_no, String rental_date) {
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<>();
		
		for(HashMap<String, Object> orderInfo : hostMapper.selectOfficeOrderRental(host_member_no, rental_date)) {
			HashMap<String, Object> map = new HashMap<>();
			
			map.put("orderInfo", orderInfo);
			map.put("guestVo", memberMapper.getMemberByNo(Integer.valueOf(String.valueOf(orderInfo.get("member_no")))));
			
			resultList.add(map);
		}
		
		return resultList;
	}
	
	public HashMap<String, Object> getOrderDetailInfo(int order_no) {
		HashMap<String, Object> resultMap = new HashMap<>();
		
		HashMap<String, Object> orderInfo = hostMapper.selectOfficeOrder(order_no);
		resultMap.put("orderInfo", orderInfo);
		ArrayList<RentalVo> rentalList = hostMapper.selectRentalList(order_no);
		long totalPrice = 0; 
		for(RentalVo rentalVo : rentalList) {
			totalPrice += rentalVo.getRental_price();
		}
		resultMap.put("rentalList", rentalList);
		resultMap.put("totalPrice", totalPrice);
		resultMap.put("guestVo", memberMapper.getMemberByNo(Integer.valueOf(String.valueOf(orderInfo.get("member_no")))));
		
		return resultMap;
	}
	
	public void modifyRentalStatus(int rental_no, String rental_status) {
		hostMapper.updateRentalStatus(rental_no, rental_status);
	}
	
	public OrderVo getOrderByRentalNo(int rental_no) {
		return hostMapper.selectOrderByRentalNo(rental_no);
	}
	
	public RentalVo getRental(int rental_no) {
		return hostMapper.selectRental(rental_no);
	}
	
	public ArrayList<HashMap<String, Object>> getOrderList(String category, String searchKeyword, boolean onlyCancel) {
		
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<>();
		
		for(HashMap<String, Object>  map : hostMapper.selectOrderMember(category, searchKeyword)) {
			HashMap<String, Object> resultMap = new HashMap<>();
			
			int order_no = Integer.valueOf(String.valueOf(map.get("order_no")));
			
			ArrayList<RentalVo> rentalList = hostMapper.selectRentalByOrderNo(order_no, onlyCancel);
			
			if(onlyCancel && rentalList.size() == 0) {
				continue;
			} else {
				resultMap.put("orderInfo", map);
				resultMap.put("officeVo", hostMapper.selectOfficeByOrderNo(order_no));
				resultMap.put("rentalList", rentalList);
				resultMap.put("totalPrice", rentalList.stream().mapToInt(RentalVo::getRental_price).sum());
			}
			
			resultList.add(resultMap);
		}
		
		return resultList;
	}
	
	public ArrayList<RentalVo> getMonthRental(int member_no, String rental_date) {
		
		String[] splitRentalDate = rental_date.split("-");
		
		String year = splitRentalDate[0];
		String month = splitRentalDate[1];
		
		String startDay = year + "-" + month + "-01";
		String endDay = year + "-" + month + "-31";
		
		return hostMapper.selectMonthRental(member_no, startDay, endDay);
	}
	
	public ArrayList<HashMap<String, Object>> getRentalProportion(int member_no) {
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<>();
		
		ArrayList<HashMap<String, String>> rentalProportionList = hostMapper.selectRentalProportion(member_no);				
		int totalCnt = rentalProportionList.stream().mapToInt(a -> Integer.valueOf(a.get("cnt"))).sum();
		long totalPrice = rentalProportionList.stream().mapToInt(a -> Integer.valueOf(a.get("totalPrice"))).sum();
		
		for(HashMap<String, String> rentalProportion : rentalProportionList) {
			HashMap<String, Object> map = new HashMap<>();
			
			int office_no = Integer.valueOf(rentalProportion.get("office_no"));
			map.put("office_no", rentalProportion.get("office_no"));
			map.put("cnt", rentalProportion.get("cnt"));
			map.put("totalPrice", rentalProportion.get("totalPrice"));

			String office_approve_date_str = rentalProportion.get("office_approve_date");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			ArrayList<BusinessDayVo> businessDayList = guestMapperB.getBusinessDayInfoByOfficeNo(office_no);
			List<String> dayList = businessDayList.stream().map(a -> a.getBusiness_day()).collect(Collectors.toList());
			try {
				Date office_approve_date = formatter.parse(office_approve_date_str);
				
				Calendar registDate = Calendar.getInstance();
				registDate.setTime(office_approve_date);
				Calendar today = Calendar.getInstance();
				today.setTime(new Date());

				for (Date date = registDate.getTime(); registDate.before(today); registDate.add(Calendar.DATE, 1), date = registDate.getTime()) {
					
				    // 요기부텅
				}
			} catch (ParseException e) {
				System.out.println("date parse 익셉션]" + e.getMessage());
			}
						
			
			
		}
		
		return resultList;
	}
	
}
