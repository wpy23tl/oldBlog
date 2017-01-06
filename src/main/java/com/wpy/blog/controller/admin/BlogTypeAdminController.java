package com.wpy.blog.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.wpy.blog.entity.BlogType;
import com.wpy.blog.service.BlogTypeService;
import com.wpy.blog.util.ResponseUtil;


@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {

	@Resource
	private BlogTypeService blogTypeService;
	
	@RequestMapping("/list")
	public  String blogManage(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		
		List<BlogType> blogTypeList=blogTypeService.getAllBlogType();
		Integer total=blogTypeService.getTotalCount();
		Map<String,Object> result = new HashMap<>();
		result.put("rows",blogTypeList);
		result.put("total", total);
		String json = JSON.toJSONString(result);
		ResponseUtil.write(response, json);
	    return null;
	}
	
	@RequestMapping("/deleteBlogType")
	public void deleteBlogType(HttpServletRequest request,HttpServletResponse response,String ids){
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++){
			blogTypeService.deleteBlogType(Integer.valueOf(idsArray[i]));
		}
		
	}
	
	@RequestMapping("/addBlogType")
	public void addBlogType(HttpServletRequest request,HttpServletResponse response,BlogType blogType){
		blogTypeService.addBlogType(blogType);
		
	}
	
}
