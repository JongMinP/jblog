package com.cafe24.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.PostDao;

@Service
public class PostService {
	
	@Autowired
	private PostDao dao;

}
