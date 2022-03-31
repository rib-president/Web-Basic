package com.teamb.shareoffice.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CouponVo {
	
	private int coupon_no;
	private String coupon_name;
	private int coupon_discount;
	private int coupon_count;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date coupon_useDate;
	private Date coupon_date;
	
	public CouponVo() {
		super();
	}

	public CouponVo(int coupon_no, String coupon_name, int coupon_discount, int coupon_count, Date coupon_useDate,
			Date coupon_date) {
		super();
		this.coupon_no = coupon_no;
		this.coupon_name = coupon_name;
		this.coupon_discount = coupon_discount;
		this.coupon_count = coupon_count;
		this.coupon_useDate = coupon_useDate;
		this.coupon_date = coupon_date;
	}

	public int getCoupon_no() {
		return coupon_no;
	}

	public void setCoupon_no(int coupon_no) {
		this.coupon_no = coupon_no;
	}

	public String getCoupon_name() {
		return coupon_name;
	}

	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public int getCoupon_discount() {
		return coupon_discount;
	}

	public void setCoupon_discount(int coupon_discount) {
		this.coupon_discount = coupon_discount;
	}

	public int getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(int coupon_count) {
		this.coupon_count = coupon_count;
	}

	public Date getCoupon_useDate() {
		return coupon_useDate;
	}

	public void setCoupon_useDate(Date coupon_useDate) {
		this.coupon_useDate = coupon_useDate;
	}

	public Date getCoupon_date() {
		return coupon_date;
	}

	public void setCoupon_date(Date coupon_date) {
		this.coupon_date = coupon_date;
	}
	
	
}
