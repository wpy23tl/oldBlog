package com.wpy.blog.dao;

import java.util.List;

import com.wpy.blog.entity.Blog;

public interface BlogDao  {

	/**
	 * 增加
	 * @param data
	 * @return
	 */
	int insert(Blog data);
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
	int updateByPrimaryKey(Blog data);
	/**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
	Blog selectByPrimaryKey(Integer id);
	/**
	 * 通过Model获取数据
	 * @param id
	 * @return
	 */
	List<Blog> selectByModel(Blog data);
	/**
	 * 查询当前表所有数据
	 * @param id
	 * @return
	 */
	List<Blog> selectAll();
	
}
