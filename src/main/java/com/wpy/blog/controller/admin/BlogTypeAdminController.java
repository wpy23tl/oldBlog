package com.wpy.blog.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wpy.blog.entity.BlogType;
import com.wpy.blog.service.BlogTypeService;


@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {

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
	@RequestMapping("/list")
	public  String blogManage(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		
		List<BlogType> blogTypeList=blogTypeService.getAllBlogType();
		//model.addAttribute("blogTypelist",blogTypeList);
		request.setAttribute("blogTypelist",blogTypeList);
	    return null;
	}
	
}
