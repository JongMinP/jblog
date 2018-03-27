package com.cafe24.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;

	public BlogVo searchBlog(Long no) {

		return sqlSession.selectOne("blog.blogByNo", no);

	}

	public boolean insertBlog(Long userNo) {
		int result = sqlSession.insert("blog.insertByNo", userNo);

		return result == 1;
	}

	public boolean updateBlog(BlogVo vo) {

		int result = sqlSession.update("blog.updateBlog", vo);

		return result == 1;
	}

	public List<BlogVo> getList() {

		return sqlSession.selectList("blog.getList");

	}
	
	public BlogVo findBlogByUserId(String id) {
		
		return sqlSession.selectOne("blog.blogByUserId",id);
	}

}
