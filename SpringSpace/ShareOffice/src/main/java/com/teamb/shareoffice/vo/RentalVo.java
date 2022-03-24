package com.teamb.shareoffice.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RentalVo {
	
	private int rental_no;
	private int order_no;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rental_date;
	private int rental_price;
	public RentalVo() {
		super();
	}
	public RentalVo(int rental_no, int order_no, Date rental_date, int rental_price) {
		super();
		this.rental_no = rental_no;
		this.order_no = order_no;
		this.rental_date = rental_date;
		this.rental_price = rental_price;
	}
	public int getRental_no() {
		return rental_no;
	}
	public void setRental_no(int rental_no) {
		this.rental_no = rental_no;
	}
	
	public int getOrder_no() {
		return order_no;
	}
	
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	
	public Date getRental_date() {
		return rental_date;
	}
	public void setRental_date(Date rental_date) {
		this.rental_date = rental_date;
	}
	public int getRental_price() {
		return rental_price;
	}
	public void setRental_price(int rental_price) {
		this.rental_price = rental_price;
	}


}
