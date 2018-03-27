package com.cafe24.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog.dto.JSONResult;
import com.cafe24.jblog.repository.UserDao;
import com.cafe24.jblog.vo.UserVo;

@Controller("userAPIController")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserDao dao;

	@ResponseBody
	@RequestMapping("/checkid")
	public JSONResult checkID(@RequestParam(value = "id", required = true, defaultValue = "") String id) {

		UserVo vo = dao.getByID(id);

		return JSONResult.success(vo == null ? "not exists" : "exist");
	}

}
