package com.corretto.board.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ArticleVo {
	private int id;
	private int board_id;
	private String title;
	private String content;
	private int view_count;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_datetime;
	
	public ArticleVo() {
		super();
	}
	public ArticleVo(int id, int board_id, String title, String content, int view_count, Date created_datetime) {
		super();
		this.id = id;
		this.board_id = board_id;
		this.title = title;
		this.content = content;
		this.view_count = view_count;
		this.created_datetime = created_datetime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public Date getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}
	
	
}
