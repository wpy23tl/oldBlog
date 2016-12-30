package com.wpy.blog.dao;

import java.util.List;

public interface BaseMapper<T,V> {

	/**
	 * 增加
	 * @param data
	 * @return
	 */
	int insert(T data);
	/**
	 * 根据主键id删除
	 * @param id
	 * @return
	 */
	int deleteByPrimarKey(V id);
	/**
	 * 根据主键id修改
	 * @param id
	 * @return
	 */
	int updateByPrimaryKey(T data);
	/**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(V id);
	/**
	 * 通过Model获取数据
	 * @param id
	 * @return
	 */
	List<T> selectByModel(T data);
	/**
	 * 查询当前表所有数据
	 * @param id
	 * @return
	 */
	List<T> selectAll();
	
}
