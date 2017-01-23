package com.wpy.blog.dao;

import java.util.List;
import java.util.Map;

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
	List<Blog> selectAll(Map<String,Object> map);
	/**
	 * 查询总记录数
	 * @return
	 */
	Integer getTotalCount();
	/**
	 * @author wpy
	 * @description  获取上一篇博客信息
	 * @date 2017年1月12日
	 * @return
	 */
	Blog getLastBlog(Integer id);
	/**
	 * @author wpy
	 * @description 获取下一篇博客信息 
	 * @date 2017年1月12日
	 * @return
	 */
	Blog getNextBlog(Integer id);
	/**
	 * @author wpy
	 * @desc 根据点击率排行
	 * @date 2017年1月18日
	 * @return
	 */
	List<Blog> getRankByClickHit();
	/**
	 * @author wpy
	 * @desc 根据创建时间拍行
	 * @date 2017年1月18日
	 * @return
	 */
	List<Blog> getRankByCreateTime();
	/**
	 * @author wpy
	 * @desc 随机获取博客文章
	 * @date 2017年1月18日
	 * @return
	 */
	List<Blog> getRankByRandom();
	/**
	 * @author wpy
	 * @desc 查询博主推荐
	 * @date 2017年1月19日
	 * @return
	 */
	List<Blog> selectBloggerRecommend();

	/**
	 * 查询具有banner的博客
	 * @return
	 */
	List<Blog> selectBanner();
}
