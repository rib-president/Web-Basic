package com.teamb.shareoffice.guest.mapper;

import java.util.*;

public interface GuestMapperRN {
	public ArrayList<HashMap<String, Object>> selectMemberCoupon(int member_no);
	public void useCoupon(int allot_no);
}
