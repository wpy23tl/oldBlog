package com.wpy.blog.service;



import java.util.List;
import java.util.Map;

import com.wpy.blog.entity.Blog;
import com.wpy.blog.entity.BlogType;

public interface BlogTypeService {

	
	public void addBlogType(BlogType blog);
	public void updateBlogType(BlogType blog);
	public void deleteBlogType(Integer id);
	public BlogType getBlogTypeById(Integer id);
	public List<BlogType> getAllBlogType(Map<String,Object> map);
	public Integer getTotalCount();
	List<BlogType> getCount(Map<String,Object> map);
}
