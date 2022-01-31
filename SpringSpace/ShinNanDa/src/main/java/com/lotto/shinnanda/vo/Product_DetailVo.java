package com.lotto.shinnanda.vo;

public class Product_DetailVo {
	private int product_detail_no;
	private int product_no;
	private String product_detail_option;
	private int product_detail_stock;
	
	public Product_DetailVo() {
		super();
	}

	public Product_DetailVo(int product_detail_no, int product_no, String product_detail_option,
			int product_detail_stock) {
		super();
		this.product_detail_no = product_detail_no;
		this.product_no = product_no;
		this.product_detail_option = product_detail_option;
		this.product_detail_stock = product_detail_stock;
	}

	public int getProduct_detail_no() {
		return product_detail_no;
	}

	public void setProduct_detail_no(int product_detail_no) {
		this.product_detail_no = product_detail_no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getProduct_detail_option() {
		return product_detail_option;
	}

	public void setProduct_detail_option(String produt_detail_option) {
		this.product_detail_option = produt_detail_option;
	}

	public int getProduct_detail_stock() {
		return product_detail_stock;
	}

	public void setProduct_detail_stock(int product_detail_stock) {
		this.product_detail_stock = product_detail_stock;
	}
}
