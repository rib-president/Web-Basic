package com.corretto.board.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AttachmentVo {
	
	private int id;
	private int article_id;
	private String location;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_datetime;
	
	public AttachmentVo() {
		super();
	}

	public AttachmentVo(int id, int article_id, String location, Date created_datetime) {
		super();
		this.id = id;
		this.article_id = article_id;
		this.location = location;
		this.created_datetime = created_datetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}
	
	
}
