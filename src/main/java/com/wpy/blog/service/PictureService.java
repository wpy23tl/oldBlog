package com.wpy.blog.service;


import com.wpy.blog.entity.Picture;

import java.util.List;
import java.util.Map;

public interface PictureService {

	
	public int add(Picture blog);
	public void update(Picture blog);
	public void delete(Integer id);
	public Picture getBlogById(Integer id);
	public List<Picture> getAll(Map<String, Object> map);
	public Integer getTotalCount();
}
