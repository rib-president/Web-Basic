package com.lotto.shinnanda.vo;

public class Product_CategoryVo {
	private int product_category_no;
	private String product_category_name;
	
	public Product_CategoryVo() {
		super();
	}

	public Product_CategoryVo(int product_category_no, String product_category_name) {
		super();
		this.product_category_no = product_category_no;
		this.product_category_name = product_category_name;
	}

	public int getProduct_category_no() {
		return product_category_no;
	}

	public void setProduct_category_no(int product_category_no) {
		this.product_category_no = product_category_no;
	}

	public String getProduct_category_name() {
		return product_category_name;
	}

	public void setProduct_category_name(String product_category_name) {
		this.product_category_name = product_category_name;
	}
}
