package com.wpy.blog.service;


import com.wpy.blog.entity.BlogType;
import com.wpy.blog.entity.Link;

import java.util.List;
import java.util.Map;

public interface LinkService {

	public void addLink(Link link);
	public void updateLink(Link link);
	public void deleteLink(Integer id);
	public Link getLinkById(Integer id);
	public List<Link> getAllLink(Map<String, Object> map);
	public Integer getTotalCount();
	List<Link> getCount(Map<String, Object> map);
}
