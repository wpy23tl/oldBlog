package com.wpy.blog.dao;

import com.wpy.blog.entity.Picture;

public interface PictureDao {

	/**
	 * 增加
	 * @param data
	 * @return
	 */
	int insert(Picture picture);
	/**
	 * 根据主键id删除
	 * @param id
	 * @return
	 */
	int deleteByPrimarKey(Integer id);
	/**
	 * 根据主键id修改
	 * @param id
	 * @return
	 */
	int updateByPrimaryKey(Picture data);
	/**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
	Picture selectByPrimaryKey(Integer id);
}
