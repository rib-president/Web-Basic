package com.lotto.shinnanda.vo;

public class CartVo {
	private int cart_no;
	private int product_detail_no;
	private int member_no;
	private int cart_count;
	
	public CartVo() {
		super();
	}

	public CartVo(int cart_no, int product_detail_no, int member_no, int cart_count) {
		super();
		this.cart_no = cart_no;
		this.product_detail_no = product_detail_no;
		this.member_no = member_no;
		this.cart_count = cart_count;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getProduct_detail_no() {
		return product_detail_no;
	}

	public void setProduct_detail_no(int product_detail_no) {
		this.product_detail_no = product_detail_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getCart_count() {
		return cart_count;
	}

	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
}
