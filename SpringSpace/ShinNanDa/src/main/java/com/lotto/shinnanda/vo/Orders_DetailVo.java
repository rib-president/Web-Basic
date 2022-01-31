package com.lotto.shinnanda.vo;

public class Orders_DetailVo {
	private int orders_detail_no;
	private int orders_no;
	private int product_detail_no;
	private int orders_detail_count;
	
	public Orders_DetailVo() {
		super();
	}

	public Orders_DetailVo(int orders_detail_no, int orders_no, int product_detail_no, int orders_detail_count) {
		super();
		this.orders_detail_no = orders_detail_no;
		this.orders_no = orders_no;
		this.product_detail_no = product_detail_no;
		this.orders_detail_count = orders_detail_count;
	}

	public int getOrders_detail_no() {
		return orders_detail_no;
	}

	public void setOrders_detail_no(int orders_detail_no) {
		this.orders_detail_no = orders_detail_no;
	}

	public int getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}

	public int getProduct_detail_no() {
		return product_detail_no;
	}

	public void setProduct_detail_no(int product_detail_no) {
		this.product_detail_no = product_detail_no;
	}

	public int getOrders_detail_count() {
		return orders_detail_count;
	}

	public void setOrders_detail_count(int orders_detail_count) {
		this.orders_detail_count = orders_detail_count;
	}
}
