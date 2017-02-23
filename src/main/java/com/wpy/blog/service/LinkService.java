package com.wpy.blog.service;


import com.wpy.blog.entity.BlogType;
import com.wpy.blog.entity.Link;

import java.util.List;
import java.util.Map;

public interface LinkService {

	public void add(Link link);
	public void update(Link link);
	public void delete(Integer id);
	public Link getLinkById(Integer id);
	public List<Link> getAll(Map<String, Object> map);
	public Integer getTotalCount();
	List<Link> getCount(Map<String, Object> map);
}
