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
import com.wpy.blog.service.BlogService;
import com.wpy.blog.util.DateTimeUtil;
import com.wpy.blog.util.ResponseUtil;
import com.wpy.blog.vo.BlogVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

	@Resource
	private BlogService blogService;
 	
	@RequestMapping("/blogManage")
	public  String blogManage(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		
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
	
}
