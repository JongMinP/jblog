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

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private FileUploadService fileUploadService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PostService postService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String goBlog(@PathVariable("id") String id, Model model) {

		BlogVo vo = blogService.blogById(id);

		model.addAttribute("blog", vo);

		return "blog/blog-main";
	}

	@RequestMapping(value = "/{id}/admin/basic", method = RequestMethod.GET)
	public String blogBasic(@PathVariable("id") String id, Model model) {

		BlogVo vo = blogService.blogById(id);

		model.addAttribute("blog", vo);

		return "blog/blog-admin-basic";
	}

	@RequestMapping(value = "/{id}/admin/basic", method = RequestMethod.POST)
	public String blogBasic(Model model, @RequestParam("title") String title,
			@RequestParam("logo-file") MultipartFile multipartFile, @RequestParam("no") Long no) {

		String image = fileUploadService.restore(multipartFile);

		BlogVo vo = new BlogVo();

		vo.setUserNo(no);
		vo.setTitle(title);
		vo.setImage(image);

		blogService.blogUpdate(vo);

		model.addAttribute("blog", vo);

		return "blog/blog-main";
	}

	@RequestMapping(value = "/{id}/admin/category", method = RequestMethod.GET)
	public String blogCategory(@PathVariable("id") String id, Model model) {

		BlogVo vo = blogService.blogById(id);

		model.addAttribute("blog", vo);

		return "blog/blog-admin-category";
	}

	@RequestMapping(value = "/{id}/admin/write", method = RequestMethod.GET)
	public String blogWrite(Model model, @PathVariable("id") String id) {

		List<CategoryVo> list = categoryService.getList();

		BlogVo vo = blogService.blogById(id);

		model.addAttribute("blog", vo);
		model.addAttribute("categorys", list);

		return "blog/blog-admin-write";
	}

	@RequestMapping(value = "/{id}/admin/write", method = RequestMethod.POST)
	public String blogWrite(@ModelAttribute PostVo vo,
			@PathVariable("id") String id) {

		System.out.println(vo);
		postService.postUpdate(vo);

		return "redirect:/blog/" +id;
	}

}
