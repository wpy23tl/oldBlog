package com.wpy.blog.service;



import java.util.List;

import com.wpy.blog.entity.Blog;
import com.wpy.blog.entity.BlogType;

public interface BlogTypeService {

	
	public void addBlogType(BlogType blog);
	public void updateBlogType(BlogType blog);
	public void deleteBlogType(Integer id);
	public BlogType getBlogTypeById(Integer id);
	public List<BlogType> getAllBlogType();
	public Integer getTotalCount();
}
