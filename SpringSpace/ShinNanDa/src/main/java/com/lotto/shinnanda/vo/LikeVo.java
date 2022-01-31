package com.lotto.shinnanda.vo;

import java.util.Date;

public class LikeVo {
	private int like_no;
	private int board_no;
	private int member_no;
	private int likecategory_no;
	private Date like_date;
	
	public LikeVo() {
		super();
	}

	public LikeVo(int like_no, int board_no, int member_no, int likecategory_no, Date like_date) {
		super();
		this.like_no = like_no;
		this.board_no = board_no;
		this.member_no = member_no;
		this.likecategory_no = likecategory_no;
		this.like_date = like_date;
	}

	public int getLike_no() {
		return like_no;
	}

	public void setLike_no(int like_no) {
		this.like_no = like_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getLikecategory_no() {
		return likecategory_no;
	}

	public void setLikecategory_no(int likecategory_no) {
		this.likecategory_no = likecategory_no;
	}

	public Date getLike_date() {
		return like_date;
	}

	public void setLike_date(Date like_date) {
		this.like_date = like_date;
	}
}
