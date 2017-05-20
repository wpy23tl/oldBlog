package com.wpy.blog.service.impl;

import com.wpy.blog.dao.PictureDao;
import com.wpy.blog.entity.Picture;
import com.wpy.blog.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("pictureService")
public class PictureServiceImpl implements PictureService {
	@Resource
	private PictureDao pictureDao;


	@Override
	public int add(Picture blog) {
		return pictureDao.insert(blog);
	}

	@Override
	public void update(Picture blog) {
		pictureDao.updateByPrimaryKey(blog);
	}

	@Override
	public void delete(Integer id) {
		pictureDao.deleteByPrimarKey(id);
	}

	@Override
	public Picture getBlogById(Integer id) {
		return pictureDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Picture> getAll(Map<String, Object> map) {
		return null;
	}

	@Override
	public Integer getTotalCount() {
		return null;
	}
}
