package com.cafe24.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.jblog.service.BlogService;
import com.cafe24.jblog.service.CategoryService;
import com.cafe24.jblog.service.FileUploadService;
import com.cafe24.jblog.service.PostService;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;
import com.cafe24.security.Auth;
import com.cafe24.security.Auth.Role;

@Auth(role = Role.ADMIN)
@Controller
@RequestMapping("/{id:(?!assets|uploads).*}/admin")
public class AdminController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private FileUploadService fileUploadService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PostService postService;

	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public String blogBasic(@PathVariable("id") String id, Model model) {

		BlogVo vo = blogService.blogById(id);

		model.addAttribute("blog", vo);

		return "blog/blog-admin-basic";
	}

	@RequestMapping(value = "/basic", method = RequestMethod.POST)
	public String blogBasic(Model model, @RequestParam("logo-file") MultipartFile multipartFile,
			@ModelAttribute BlogVo blogVo, @PathVariable("id") String id) {

		String image = (multipartFile.isEmpty() == true) ? (blogService.blogById(id)).getImage()
				: fileUploadService.restore(multipartFile);

		blogVo.setImage(image);

		blogService.blogUpdate(blogVo);

		model.addAttribute("blog", blogVo);

		return "redirect:/" + id;
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String blogCategory(@PathVariable("id") String id, Model model) {

		BlogVo vo = blogService.blogById(id);

		List<CategoryVo> list = categoryService.getList(vo.getNo());

		model.addAttribute("categorys", list);
		model.addAttribute("blog", vo);

		return "blog/blog-admin-category";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String blogWrite(Model model, @PathVariable("id") String id) {

		BlogVo vo = blogService.blogById(id);

		List<CategoryVo> list = categoryService.getList(vo.getNo());

		model.addAttribute("blog", vo);
		model.addAttribute("categorys", list);

		return "blog/blog-admin-write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String blogWrite(@ModelAttribute PostVo vo, @PathVariable("id") String id) {

		postService.postUpdate(vo);

		return "redirect:/" + id;
	}

}
