package com.cafe24.jblog.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
	private Long no;
	
	@NotEmpty
	@Length(min=2,max =10)
	private String id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Pattern(regexp="^[0-9a-zA-Z]{4,12}$")
	private String password;
	
	private String joinDate;

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", name=" + name + ", password=" + password + ", joinDate="
				+ joinDate + "]";
	}

}
