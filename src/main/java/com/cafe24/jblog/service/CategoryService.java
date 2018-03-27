package com.cafe24.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.CategoryDao;
import com.cafe24.jblog.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao dao;

	public List<CategoryVo> getList() {
		List<CategoryVo> list = dao.getList();
		
		return list;
	}

}
