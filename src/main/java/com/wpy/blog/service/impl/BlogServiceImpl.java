package com.wpy.blog.service.impl;

import java.util.List;
import java.util.Map;

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

	

	public Integer getTotalCount() {
		return blogDao.getTotalCount();
	}

	@Override
	public List<Blog> getAllBlog(Map<String, Object> map) {
		return blogDao.selectAll(map);
	}

	@Override
	public Blog getLastBlog(Integer id) {
		
		return blogDao.getLastBlog(id);
	}

	@Override
	public Blog getNextBlog(Integer id) {
		
		return blogDao.getNextBlog(id);
	}

	@Override
	public List<Blog> getRankByClickHit() {
		return blogDao.getRankByClickHit();
	}

	@Override
	public List<Blog> getRankByCreateTime() {
		return blogDao.getRankByCreateTime();
	}

	@Override
	public List<Blog> getRankByRandom() {
		return blogDao.getRankByRandom();
	}

}
