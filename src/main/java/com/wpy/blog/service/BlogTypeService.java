package com.wpy.blog.service;



import java.util.List;
import java.util.Map;

import com.wpy.blog.entity.Blog;
import com.wpy.blog.entity.BlogType;

public interface BlogTypeService {

	
	public void add(BlogType blog);
	public void update(BlogType blog);
	public void delete(Integer id);
	public BlogType getBlogTypeById(Integer id);
	public List<BlogType> getAll(Map<String,Object> map);
	public Integer getTotalCount();
	List<BlogType> getCount(Map<String,Object> map);
}
