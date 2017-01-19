package com.wpy.blog.service;


import java.util.List;
import java.util.Map;

import com.wpy.blog.entity.Blog;

public interface BlogService {

	
	public void addBlog(Blog blog);
	public void updateBlog(Blog blog);
	public void deleteBlog(Integer id);
	public Blog getBlogById(Integer id);
	
	public List<Blog> getAllBlog(Map<String,Object> map);
	public Integer getTotalCount();
	/**
	 * @author wpy
	 * @desc 根据点击数排行
	 * @date 2017年1月18日
	 * @return
	 */
	public List<Blog> getRankByClickHit();
	/**
	 * @author wpy
	 * @desc 获取上一个博客信息
	 * @date 2017年1月12日
	 * @param id
	 * @return
	 */
	public Blog getLastBlog(Integer id);
	/**
	 * @author wpy
	 * @desc 获取下一个博客新
	 * @date 2017年1月12日
	 * @param id
	 * @return
	 */
	public Blog getNextBlog(Integer id);
	/**
	 * @author wpy
	 * @desc 根据创建时间排序
	 * @date 2017年1月18日
	 * @return
	 */
	List<Blog> getRankByCreateTime();
	/**
	 * @author wpy
	 * @desc 获取随机文章
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
	List<Blog> getBloggerRecommend();
}
