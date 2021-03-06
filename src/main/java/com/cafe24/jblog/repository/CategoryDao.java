package com.cafe24.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;

	public List<CategoryVo> getList(Long bno) {

		return sqlSession.selectList("category.getList", bno);
	}

	public boolean insertCategory(CategoryVo vo) {

		int result = sqlSession.insert("category.insertCategory", vo);

		return result == 1;
	}

	public CategoryVo getCategory(Long no) {

		return sqlSession.selectOne("category.getCategory", no);

	}

	public boolean deleteCategory(Long no) {
		int result = sqlSession.delete("category.deleteCategory", no);

		return result == 1;
	}

	public boolean updateCategory(Long no) {
		int result = sqlSession.update("category.updateCategory", no);

		return result == 1;
	}

}
