package com.cafe24.jblog.vo;

public class BlogVo {
	private Long no;
	private String title;
	private String image;
	private Long userNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "BlogVo [no=" + no + ", title=" + title + ", image=" + image + ", userNo=" + userNo + "]";
	}

}
