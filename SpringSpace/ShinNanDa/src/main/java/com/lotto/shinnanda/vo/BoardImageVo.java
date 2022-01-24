package com.lotto.shinnanda.vo;

public class BoardImageVo {
	private int image_no;
	private int board_no;
	private String image_url;
	private String image_originalname;
	
	public BoardImageVo() {
		super();
	}

	public BoardImageVo(int image_no, int board_no, String image_url, String image_originalname) {
		super();
		this.image_no = image_no;
		this.board_no = board_no;
		this.image_url = image_url;
		this.image_originalname = image_originalname;
	}

	public int getImage_no() {
		return image_no;
	}

	public void setImage_no(int image_no) {
		this.image_no = image_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getImage_originalname() {
		return image_originalname;
	}

	public void setImage_originalname(String image_originalname) {
		this.image_originalname = image_originalname;
	}
}
