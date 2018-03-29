package com.cafe24.jblog.vo;

public class CategoryVo {
	private Long no;
	private String name;
	private Long postCount;
	private String content;
	private Long blogNo;
	private String regDate;

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPostCount() {
		return postCount;
	}

	public void setPostCount(Long postCount) {
		this.postCount = postCount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getBlogNo() {
		return blogNo;
	}

	public void setBlogNo(Long blogNo) {
		this.blogNo = blogNo;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", postCount=" + postCount + ", content=" + content
				+ ", blogNo=" + blogNo + ", regDate=" + regDate + "]";
	}

}
