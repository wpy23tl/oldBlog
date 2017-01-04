package com.wpy.blog.service;

import java.util.List;

import com.wpy.blog.entity.Blog;

public interface BlogService {

	
	public void addBlog(Blog blog);
	public void updateBlog(Blog blog);
	public void deleteBlog(Integer id);
	public Blog getBlogById(Integer id);
	public List<Blog> getAllBlog();
	public Integer getTotalCount();
}
