package com.corretto.board.vo;

public class BoardVo {
	private int id;
	private String name;
	
	public BoardVo() {
		super();
	}

	public BoardVo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
