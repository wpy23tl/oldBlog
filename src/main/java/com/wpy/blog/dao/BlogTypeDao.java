package com.wpy.blog.dao;


import java.util.List;

import com.wpy.blog.entity.BlogType;


public interface BlogTypeDao  {

	/**
	 * 增加
	 * @param data
	 * @return
	 */
	int insert(BlogType data);
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
	int updateByPrimaryKey(BlogType data);
	/**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
	BlogType selectByPrimaryKey(Integer id);
	/**
	 * 通过Model获取数据
	 * @param id
	 * @return
	 */
	List<BlogType> selectByModel(BlogType data);
	/**
	 * 查询当前表所有数据
	 * @param id
	 * @return
	 */
	List<BlogType> selectAll();
	/**
	 * 查询总记录数
	 * @return
	 */
	Integer getTotalCount();
	
}
