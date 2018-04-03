package com.cafe24.jblog.controller;

import java.util.List;
import java.util.Optional;

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
import com.cafe24.jblog.vo.UserVo;
import com.cafe24.security.Auth;
import com.cafe24.security.Auth.Role;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/{id:(?!assets|uploads).*}")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PostService postService;

	@RequestMapping({ "", "/{path1}", "/{path1}/{path2}" })
	public String goBlog(@PathVariable("id") String id, Model model, @PathVariable("path1") Optional<Long> path1,
			@PathVariable("path2") Optional<Long> path2) {

		Long pno = 0L;
		Long cno = 1L;

		if (path2.isPresent()) {
			pno = path2.get();
			cno = path1.get();
		} else if (path1.isPresent()) {
			cno = path1.get();
		}

		BlogVo vo = blogService.blogById(id);

		List<CategoryVo> list = categoryService.getList(1L);
		List<PostVo> posts = postService.getList(cno);

		CategoryVo category = categoryService.getCategory(cno);

		PostVo post = null;
		if (!posts.isEmpty())
			post = (pno == 0) ? posts.get(0) : postService.getPost(pno);

		model.addAttribute("blog", vo);
		model.addAttribute("category", category);
		model.addAttribute("categorys", list);
		model.addAttribute("post", post);
		model.addAttribute("posts", posts);

		return "blog/blog-main";
	}

}
