package com.cafe24.jblog.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.jblog.service.UserService;
import com.cafe24.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	private static final Log LOG = LogFactory.getLog(UserController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "/user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVo vo) {
		
		UserVo authUser = service.getUser(vo);
		
		if(authUser == null) {
			
		}
		
		return "/user/login";
		
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {

		return "/user/join";
	}

	@RequestMapping(value = "/joinsuccess", method = RequestMethod.POST)
	public String join(@ModelAttribute UserVo vo) {

		LOG.warn(vo);

		service.join(vo);

		return "/user/joinsuccess";
	}

}
