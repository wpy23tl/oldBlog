package com.wpy.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wpy.blog.dao.BlogDao;
import com.wpy.blog.entity.Blog;
import com.wpy.blog.service.BlogService;


@Service("blogService")
public class BlogServiceImpl implements BlogService {
	@Resource
	private BlogDao blogDao;
	
	public void addBlog(Blog blog) {
		
		 blogDao.insert(blog);
		
	}

	public void updateBlog(Blog blog) {
		
		blogDao.updateByPrimaryKey(blog);
	}

	public void deleteBlog(Integer id) {
		
		blogDao.deleteByPrimarKey(id);
	}

	public Blog getBlogById(Integer id) {
		
		return blogDao.selectByPrimaryKey(id);
	}

	public List<Blog> getAllBlog() {
		
		return blogDao.selectAll();
	}

}
