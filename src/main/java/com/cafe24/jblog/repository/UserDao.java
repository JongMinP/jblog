package com.cafe24.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public boolean insertUserBlog(UserVo vo) {
		int result = sqlSession.insert("user.insertUserBlog", vo);

		return result == 1;
	}

	public UserVo getUser(String id, String password) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);

		return sqlSession.selectOne("user.getUser", map);
	}

	public List<UserVo> getUser() {

		return sqlSession.selectList("user.getUsers");
	}

}
