package com.lotto.shinnanda.vo;

public class ImageVo {
	private int image_no;
	private int product_no;
	private String image_url;
	
	public ImageVo() {
		super();
	}

	public ImageVo(int image_no, int product_no, String image_url) {
		super();
		this.image_no = image_no;
		this.product_no = product_no;
		this.image_url = image_url;
	}

	public int getImage_no() {
		return image_no;
	}

	public void setImage_no(int image_no) {
		this.image_no = image_no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
}
