package com.cafe24.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.repository.UserDao;
import com.cafe24.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	@Autowired
	private BlogDao bdao;

	public UserVo getUser(UserVo vo) {

		return dao.getUser(vo.getId(), vo.getPassword());
	}

	public boolean existUser(String email) {

		return false;
	}

	public boolean join(UserVo vo) {
		int userNo = dao.insertUserBlog(vo);
		return bdao.insertBlog(vo.getNo());
	}

}
