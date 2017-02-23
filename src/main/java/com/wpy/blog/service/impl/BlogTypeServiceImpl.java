package com.wpy.blog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wpy.blog.dao.BlogTypeDao;
import com.wpy.blog.entity.BlogType;
import com.wpy.blog.service.BlogTypeService;

@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

	@Resource
	private BlogTypeDao blogTypeDao;

	@Override
	public void add(BlogType blog) {
		
		blogTypeDao.insert(blog);
	}

	@Override
	public void update(BlogType blog) {
		blogTypeDao.updateByPrimaryKey(blog);
		
	}

	@Override
	public void delete(Integer id) {
		
		 blogTypeDao.deleteByPrimarKey(id);
	}

	@Override
	public BlogType getBlogTypeById(Integer id) {
		
		return null;
	}

	

	@Override
	public Integer getTotalCount() {
		
		return blogTypeDao.getTotalCount();
	}

	@Override
	public List<BlogType> getAll(Map<String, Object> map) {
		
		return blogTypeDao.selectAll(map);
	}

	@Override
	public List<BlogType> getCount(Map<String,Object> map) {

		return blogTypeDao.selectCount(map);
	}
	
	
	

	

}
