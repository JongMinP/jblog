package com.cafe24.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao dao;

	public BlogVo blogById(String id) {
		BlogVo vo = dao.findBlogByUserId(id);

		return vo;
	}
	
	public boolean blogUpdate(BlogVo vo) {
		
		return dao.updateBlog(vo);
	}

}
