package com.cafe24.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;

	public List<PostVo> getList(Long categoryNo) {

		return sqlSession.selectList("post.getList", categoryNo);
	}

	public PostVo getPost(Long postNo) {

		return sqlSession.selectOne("post.getPost", postNo);
	}

	public boolean insertPost(PostVo vo) {

		int result = sqlSession.insert("post.insertPost", vo);

		return result == 1;
	}

	public boolean deletePost(Long postNo) {

		int result = sqlSession.delete("post.deletePost", postNo);

		return result == 1;
	}

}
