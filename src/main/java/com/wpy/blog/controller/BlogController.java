package com.wpy.blog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wpy.blog.entity.Blog;
import com.wpy.blog.entity.BlogType;
import com.wpy.blog.entity.PageBean;
import com.wpy.blog.service.BlogService;
import com.wpy.blog.service.BlogTypeService;
import com.wpy.blog.util.DateTimeUtil;
import com.wpy.blog.util.PageUtil;
import com.wpy.blog.vo.BlogVo;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Resource
	private BlogTypeService blogTypeService;
	
	@Resource
	private BlogService blogService;
	/**
	 * @author wpy
	 * @description 进入博客前台页面
	 * @date 2017年1月11日
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String pageSize){
		Map<String,Object> map = new HashMap<>();
		//获取所有博客类型
		List<BlogType> blogTypeList = blogTypeService.getAllBlogType(map);
		if("".equals(page) || page==null){
			page="1";
		}
		if("".equals(pageSize) || pageSize==null){
			pageSize="10";
		}
		PageBean pageBean = new PageBean(Integer.valueOf(page),Integer.valueOf(pageSize));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		model.addAttribute("blogTypeList",blogTypeList);
		//获取所有博客
		List<Blog> blogList =  blogService.getAllBlog(map);
		List<BlogVo> newBlogList = new ArrayList<>();
		for(Blog blog:blogList){
			Date createTime = blog.getCreateTime();
			String createTimeString = DateTimeUtil.DateToString(createTime, "yyyy-MM-dd HH:mm:ss");
			BlogVo blogVo = new BlogVo();
			BeanUtils.copyProperties(blog, blogVo);
			blogVo.setCreateTime(createTimeString);
			newBlogList.add(blogVo);
		}
		model.addAttribute("blogList",newBlogList);
		
		//获取博客总数
		Integer totalCount = blogService.getTotalCount();
		
		String pageCode = PageUtil.genPageCode(totalCount, Integer.valueOf(pageSize),Integer.valueOf(page), request);
		model.addAttribute("pageCode",pageCode);
		return "portal/index";
	}
	/**
	 * @author wpy
	 * @description 进入文章
	 * @date 2017年1月12日
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/article")
	public String article(HttpServletRequest request,HttpServletResponse response,Model model,String id){
		Map<String,Object> map = new HashMap<>();
		//获取所有博客类型
		List<BlogType> blogTypeList = blogTypeService.getAllBlogType(map);
		model.addAttribute("blogTypeList",blogTypeList);
		//获取所有博客
		List<Blog> blogList =  blogService.getAllBlog(map);
		List<BlogVo> newBlogList = new ArrayList<>();
		for(Blog blog:blogList){
			Date createTime = blog.getCreateTime();
			String createTimeString = DateTimeUtil.DateToString(createTime, "yyyy-MM-dd HH:mm:ss");
			BlogVo blogVo = new BlogVo();
			BeanUtils.copyProperties(blog, blogVo);
			blogVo.setCreateTime(createTimeString);
			newBlogList.add(blogVo);
		}
		model.addAttribute("blogList",newBlogList);
		//根据id获取博客
		Blog blog =blogService.getBlogById(Integer.valueOf(id));
		Date createTime = blog.getCreateTime();
		BlogVo blogVo = new BlogVo();
		BeanUtils.copyProperties(blog, blogVo);
		String createTimeString = DateTimeUtil.DateToString(createTime, "yyyy-MM-dd HH:mm:ss");
		blogVo.setCreateTime(createTimeString);
		model.addAttribute("blog",blogVo);
		
		//获取上一篇博客
	    Blog lastBlog =	blogService.getLastBlog(Integer.valueOf(id));
		//获取下一篇博客
		Blog nextBlog = blogService.getNextBlog(Integer.valueOf(id));
		model.addAttribute("lastBlog",lastBlog);
		model.addAttribute("nextBlog",nextBlog);
		return "portal/article";
	}
}
