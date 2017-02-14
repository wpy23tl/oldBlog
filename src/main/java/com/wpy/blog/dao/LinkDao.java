package com.wpy.blog.dao;


import com.wpy.blog.entity.Link;

import java.util.List;
import java.util.Map;


public interface LinkDao {

	/**
	 * 增加
	 * @param data
	 * @return
	 */
	int insert(Link data);
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
	int updateByPrimaryKey(Link data);
	/**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
	Link selectByPrimaryKey(Integer id);
	/**
	 * 通过Model获取数据
	 * @param id
	 * @return
	 */
	List<Link> selectByModel(Link data);
	/**
	 * 查询当前表所有数据
	 * @param id
	 * @return
	 */
	List<Link> selectAll(Map<String, Object> map);
	/**
	 * 查询总记录数
	 * @return
	 */
	Integer getTotalCount();
	/**
	 * @author wpy
	 * @desc 查询链接数量
	 * @date 2017年1月25日
	 * @return
	 */
	List<Link> selectCount(Map<String, Object> map);
}
