package com.wpy.blog.controller.admin;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.wpy.blog.entity.Blog;
import com.wpy.blog.entity.BlogType;
import com.wpy.blog.service.BlogService;
import com.wpy.blog.service.BlogTypeService;
import com.wpy.blog.util.DateTimeUtil;
import com.wpy.blog.util.ResponseUtil;
import com.wpy.blog.vo.BlogVo;


@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

	@Resource
	private BlogService blogService;
	@Resource
	private BlogTypeService blogTypeService;
 	/**
 	 * 查询所有博客
 	 * @param request
 	 * @param response
 	 * @param model
 	 * @return
 	 * @throws Exception
 	 */
	@RequestMapping("/blogManage")
	public  String blogManage(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
	return "admin/blogManage";
	}
	
	@RequestMapping("/list")
	public  String list(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		
		List<Blog> blogList=blogService.getAllBlog();
		Integer total=blogService.getTotalCount();
		
		List<BlogVo> newBlogList = new ArrayList<>();
		for(Blog blog:blogList){
			Date createTime = blog.getCreateTime();
			String createTimeString = DateTimeUtil.DateToString(createTime, "yyyy-MM-dd HH:mm:ss");
			BlogVo blogVo = new BlogVo();
			BeanUtils.copyProperties(blog, blogVo);
			blogVo.setCreateTime(createTimeString);
			newBlogList.add(blogVo);
		}
		Map<String,Object> result = new HashMap<>();
		result.put("rows",newBlogList);
		result.put("total", total);
		String json = JSON.toJSONString(result);
		ResponseUtil.write(response, json);
	return null;
	}
	/**
	 * 删除博客
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/deleteBlog")
	public void deleteBlog(HttpServletRequest request,HttpServletResponse response,String ids){
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++){
			blogService.deleteBlog(Integer.valueOf(idsArray[i]));
		}
		
		
	}
	
	@RequestMapping("/addBlog")
	public String writeBlog(HttpServletRequest request,HttpServletResponse response,Model model){
		List<BlogType> blogTypeList = blogTypeService.getAllBlogType();
		model.addAttribute("blogTypeList",blogTypeList);
		return "admin/blogAdd";
	}
	
	@RequestMapping("/saveBlog")
	public String saveBlog(HttpServletRequest request,HttpServletResponse response,Model model,Blog blog) throws Exception{
		Map<String,Object>  map = new HashMap<>();
		 try {
			 if("".equals(blog.getId()) || null == blog.getId()){
				 blogService.addBlog(blog);
			 }else{
				 Blog blog1 = blogService.getBlogById(blog.getId());
				 blog1.setBlogContent(blog.getBlogContent());
				 blog1.setBlogTitle(blog.getBlogTitle());
				 blog1.setBlogTypeId(blog.getBlogTypeId());
				 blog1.setUpdateTime(new Date());
				 blogService.updateBlog(blog1);
			 }
			 map.put("success",true);
		} catch (Exception e) {
			map.put("success",false);
			e.printStackTrace();
		}
		 String result =JSON.toJSONString(map);
		 ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/updateBlog")
	public String updateBlog(HttpServletRequest request,HttpServletResponse response,Model model,Integer id) throws Exception{
		Blog blog = blogService.getBlogById(id);
		List<BlogType> blogTypeList=blogTypeService.getAllBlogType();
		model.addAttribute("blogTitle",blog.getBlogTitle());
		model.addAttribute("blogContent",blog.getBlogContent());
		model.addAttribute("blogTypeList",blogTypeList);
		model.addAttribute("id",id);
		return "admin/blogAdd";
	}
	
}
