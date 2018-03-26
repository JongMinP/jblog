package com.cafe24.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.CategoryDao;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao dao;
	
	

}
