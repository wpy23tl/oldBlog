package com.wpy.blog.service.impl;


import com.wpy.blog.dao.BloggerDao;
import com.wpy.blog.entity.Blogger;
import com.wpy.blog.entity.Picture;
import com.wpy.blog.framework.model.DataGrid;
import com.wpy.blog.framework.model.Response;
import com.wpy.blog.service.BloggerService;
import com.wpy.blog.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 文章首页图片
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService{


	@Override
	public Response add(Picture picture) {
		return null;
	}

	@Override
	public Response update(Picture picture) {
		return null;
	}

	@Override
	public Response delete(Integer id) {
		return null;
	}

	@Override
	public Response getObjectById(Integer id) {
		return null;
	}

	@Override
	public DataGrid getAll(Map<String, Object> map) {
		return null;
	}

	@Override
	public Integer getTotalCount() {
		return null;
	}
}
