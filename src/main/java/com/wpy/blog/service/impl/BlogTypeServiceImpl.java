package com.wpy.blog.service.impl;

import java.util.List;

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
	public void addBlogType(BlogType blog) {
		
		
	}

	@Override
	public void updateBlogType(BlogType blog) {
		
		
	}

	@Override
	public void deleteBlogType(Integer id) {
		
		
	}

	@Override
	public BlogType getBlogTypeById(Integer id) {
		
		return null;
	}

	@Override
	public List<BlogType> getAllBlogType() {
		
		return blogTypeDao.selectAll();
	}

	@Override
	public Integer getTotalCount() {
		
		return null;
	}
	
	
	

	

}
