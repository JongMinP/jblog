package com.cafe24.jblog.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog.dto.JSONResult;
import com.cafe24.jblog.service.CategoryService;
import com.cafe24.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@ResponseBody
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public List<CategoryVo> insertCategory(@ModelAttribute CategoryVo vo) {

		service.addCategory(vo);

		return service.getList(vo.getBlogNo());
	}

	@ResponseBody
	@RequestMapping(value = "/removeCategory", method = RequestMethod.GET)
	public List<CategoryVo> deleteCategory(@RequestParam(value = "no", required = true, defaultValue = "0") Long no,
			@RequestParam(value = "bno", required = true, defaultValue = "0") Long bno) {

		service.removeCategory(no);

		return service.getList(bno);
	}

}
