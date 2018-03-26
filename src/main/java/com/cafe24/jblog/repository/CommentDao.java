package com.cafe24.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.CommentVo;

@Repository
public class CommentDao {

	@Autowired
	private SqlSession sqlSession;

	public List<CommentVo> getList(Long postNo) {

		return sqlSession.selectList("comment.getList", postNo);
	}

	public boolean insertComment(CommentVo vo) {

		int result = sqlSession.insert("comment.insertComment", vo);
		return result == 1;
	}

}
