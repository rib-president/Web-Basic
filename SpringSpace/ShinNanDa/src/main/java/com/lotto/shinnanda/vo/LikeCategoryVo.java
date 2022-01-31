package com.lotto.shinnanda.vo;

public class LikeCategoryVo {
	private int likecategory_no;
	private String likecategory_name;
	
	public LikeCategoryVo() {
		super();
	}

	public LikeCategoryVo(int likecategory_no, String likecategory_name) {
		super();
		this.likecategory_no = likecategory_no;
		this.likecategory_name = likecategory_name;
	}

	public int getLikecategory_no() {
		return likecategory_no;
	}

	public void setLikecategory_no(int likecategory_no) {
		this.likecategory_no = likecategory_no;
	}

	public String getLikecategory_name() {
		return likecategory_name;
	}

	public void setLikecategory_name(String likecategory_name) {
		this.likecategory_name = likecategory_name;
	}
}
