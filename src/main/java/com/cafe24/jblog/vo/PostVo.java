package com.cafe24.jblog.vo;

import java.util.List;

public class PostVo {
	private Long no;
	private String title;
	private String content;
	private Long categoryNo;
	private List<CommentVo> comments;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	public List<CommentVo> getComments() {
		return comments;
	}

	public void setComments(List<CommentVo> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "PostVo [no=" + no + ", title=" + title + ", content=" + content + ", categoryNo=" + categoryNo
				+ ", comments=" + comments + "]";
	}

}
