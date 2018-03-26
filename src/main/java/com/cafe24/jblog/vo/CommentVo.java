package com.cafe24.jblog.vo;

public class CommentVo {
	private Long no;
	private String content;
	private Long postNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getPostNo() {
		return postNo;
	}

	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}

	@Override
	public String toString() {
		return "CommentVo [no=" + no + ", content=" + content + ", postNo=" + postNo + "]";
	}

}
