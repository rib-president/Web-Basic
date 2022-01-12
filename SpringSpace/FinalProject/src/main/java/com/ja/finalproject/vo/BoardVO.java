package com.ja.finalproject.vo;

import java.util.Date;

//import org.springframework.format.annotation.DateTimeFormat;

public class BoardVO {
	private int board_no;
	private int member_no;
	private String board_title;
	private String board_content;
	private int board_readcount;
	// @DateTimeFormat(pattern="yyyy-MM-dd")
	// 웹브라우저에서 date가 날아올 일이 없어 Date Annotation 안 붙여도 됨
	// 웹브라우저  default format이 yyyy-MM-dd임
	private Date board_writedate;
	
	public BoardVO() {
		super();
	}

	public BoardVO(int board_no, int member_no, String board_title, String board_content, int board_readcount,
			Date board_writedate) {
		super();
		this.board_no = board_no;
		this.member_no = member_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_readcount = board_readcount;
		this.board_writedate = board_writedate;
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

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public int getBoard_readcount() {
		return board_readcount;
	}

	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}

	public Date getBoard_writedate() {
		return board_writedate;
	}

	public void setBoard_writedate(Date board_writedate) {
		this.board_writedate = board_writedate;
	}
}
