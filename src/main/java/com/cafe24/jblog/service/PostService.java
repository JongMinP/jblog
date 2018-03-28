package com.cafe24.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.CategoryDao;
import com.cafe24.jblog.repository.PostDao;
import com.cafe24.jblog.vo.PostVo;

@Service
public class PostService {

	@Autowired
	private PostDao dao;

	@Autowired
	private CategoryDao cdao;

	public boolean postUpdate(PostVo vo) {

		boolean rollBack = dao.insertPost(vo);

		if (!rollBack)
			return false;

		return cdao.updateCategory(vo.getCategoryNo());
	}

	public List<PostVo> getList(Long categoryNo) {

		List<PostVo> posts = dao.getList(categoryNo);

		return posts;

	}

}
