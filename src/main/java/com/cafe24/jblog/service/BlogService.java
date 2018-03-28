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
		return dao.findBlogByUserId(id);
	}

	public boolean blogUpdate(BlogVo vo) {

		return dao.updateBlog(vo);
	}

	public BlogVo blogByNo(Long no) {
		return dao.searchBlog(no);
	}

}
