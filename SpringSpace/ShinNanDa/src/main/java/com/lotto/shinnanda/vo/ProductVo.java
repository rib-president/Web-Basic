package com.lotto.shinnanda.vo;

import java.util.Date;

public class ProductVo {
	private int product_no;
	private int product_category_no;
	private int brand_no;
	private String product_title;
	private String product_model;
	//private int product_price;
	private long product_price;
	private String product_content;
	private String product_image;
	private Date product_date;
	
	public ProductVo() {
		super();
	}

	public ProductVo(int product_no, int product_category_no, int brand_no, String product_title, String product_model,
			int product_price, String product_content, String product_image, Date product_date) {
		super();
		this.product_no = product_no;
		this.product_category_no = product_category_no;
		this.brand_no = brand_no;
		this.product_title = product_title;
		this.product_model = product_model;
		this.product_price = product_price;
		this.product_content = product_content;
		this.product_image = product_image;
		this.product_date = product_date;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getProduct_category_no() {
		return product_category_no;
	}

	public void setProduct_category_no(int product_category_no) {
		this.product_category_no = product_category_no;
	}

	public int getBrand_no() {
		return brand_no;
	}

	public void setBrand_no(int brand_no) {
		this.brand_no = brand_no;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public String getProduct_model() {
		return product_model;
	}

	public void setProduct_model(String product_model) {
		this.product_model = product_model;
	}

	//public int getProduct_price() {
	public long getProduct_price() {
		return product_price;
	}
	
	//public void setProduct_price(int product_price) {
	public void setProduct_price(long product_price) {
		this.product_price = product_price;
	}

	public String getProduct_content() {
		return product_content;
	}

	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public Date getProduct_date() {
		return product_date;
	}

	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}
}
