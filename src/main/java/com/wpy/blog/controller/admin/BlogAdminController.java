package com.wpy.blog.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.wpy.blog.entity.Blog;
import com.wpy.blog.service.BlogService;

@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

	@Resource
	private BlogService blogService;
 	
	@RequestMapping("/blogManage")
	public String blogManage(HttpServletRequest request,HttpServletResponse response,Model model){
	    List<Blog> allBlogList = blogService.getAllBlog();
	    String allBlogListString = JSON.toJSONString(allBlogList);
	    return null;
	}
	
}
