package com.lotto.shinnanda.vo;

import java.util.Date;

public class OrdersVo {
	private int orders_no;
	private int member_no;
	private String orders_name;
	private String orders_phone;
	private String orders_address;
	private String orders_state;	
	private Date orders_date;
	
	public OrdersVo() {
		super();
	}

	public OrdersVo(int orders_no, int member_no, String orders_name, String orders_phone, String orders_address,
			String orders_state, Date orders_date) {
		super();
		this.orders_no = orders_no;
		this.member_no = member_no;
		this.orders_name = orders_name;
		this.orders_phone = orders_phone;
		this.orders_address = orders_address;
		this.orders_state = orders_state;
		this.orders_date = orders_date;
	}

	public int getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getOrders_name() {
		return orders_name;
	}

	public void setOrders_name(String orders_name) {
		this.orders_name = orders_name;
	}

	public String getOrders_phone() {
		return orders_phone;
	}

	public void setOrders_phone(String orders_phone) {
		this.orders_phone = orders_phone;
	}

	public String getOrders_address() {
		return orders_address;
	}

	public void setOrders_address(String orders_address) {
		this.orders_address = orders_address;
	}

	public String getOrders_state() {
		return orders_state;
	}

	public void setOrders_state(String orders_state) {
		this.orders_state = orders_state;
	}

	public Date getOrders_date() {
		return orders_date;
	}

	public void setOrders_date(Date orders_date) {
		this.orders_date = orders_date;
	}
}
