package com.wpy.blog.controller.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wpy.blog.entity.*;
import com.wpy.blog.service.BloggerService;
import com.wpy.blog.service.LinkService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.wpy.blog.service.BlogService;
import com.wpy.blog.service.BlogTypeService;
import com.wpy.blog.util.DateTimeUtil;
import com.wpy.blog.util.ResponseUtil;
import com.wpy.blog.vo.BlogVo;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

	@Resource
	private BlogService blogService;
	@Resource
	private BlogTypeService blogTypeService;
	@Resource
	private BloggerService bloggerService;
	@Resource
	private LinkService linkService;
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
	public  String list(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String pageSize) throws Exception{
		PageBean pageBean = new PageBean(Integer.valueOf(page),Integer.valueOf(pageSize));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Blog> blogList=blogService.getAllBlog(map);
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
		Map<String,Object> map=new HashMap<String,Object>();
		List<BlogType> blogTypeList = blogTypeService.getAllBlogType(map);
		model.addAttribute("blogTypeList",blogTypeList);
		return "admin/blogAdd2";
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
		Map<String,Object> map=new HashMap<String,Object>();
		List<BlogType> blogTypeList=blogTypeService.getAllBlogType(map);
		model.addAttribute("blogTitle",blog.getBlogTitle());
		model.addAttribute("blogContent",blog.getBlogContent());
		model.addAttribute("blogTypeList",blogTypeList);
		model.addAttribute("id",id);
		model.addAttribute("blogTypeId",blog.getBlogTypeId());
		return "admin/blogAdd";
	}
	/**
	 * @author wpy
	 * @desc 博主推荐
	 * @date 2017年1月19日
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/bloggerRecommend")
	public  String bloggerRecommend(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		return "admin/bloggerRecommend";
	}
	
	@RequestMapping("/recommendList")
	public  String recommendList(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
//		PageBean pageBean = new PageBean(Integer.valueOf(page),Integer.valueOf(pageSize));
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("start", pageBean.getStart());
//		map.put("size", pageBean.getPageSize());
		List<Blog> blogList=blogService.getBloggerRecommend();
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
	 * 删除推荐
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/deleteRecommend")
	public void deleteRecommend(HttpServletRequest request,HttpServletResponse response,String ids){
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++){
			Blog blog = blogService.getBlogById(Integer.valueOf(idsArray[i]));
			blog.setRecommendFlag(0);
			blogService.updateBlog(blog);
		}
		
	}
	
	@RequestMapping("/addRecommendBlog")
	public void addRecommendBlog(HttpServletRequest request,HttpServletResponse response,String ids){
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++){
			Blog blog = blogService.getBlogById(Integer.valueOf(idsArray[i]));
			blog.setRecommendFlag(1);
			blogService.updateBlog(blog);
		}
		
	}
	
	@RequestMapping("/updateRecommendBlog")
	public void updateRecommendBlog(HttpServletRequest request,HttpServletResponse response,String id,String recommendNo) throws Exception{
			Map<String, Object> map= new HashMap<>();
			Blog blog = blogService.getBlogById(Integer.valueOf(id));
			blog.setRecommendNo(Integer.valueOf(recommendNo));
			try {
				blog.setRecommendNo(Integer.valueOf(recommendNo));
				blogService.updateBlog(blog);
				map.put("success", true);
			} catch (Exception e) {
				map.put("success", false);
				e.printStackTrace();
			}
			String result = JSON.toJSONString(map);
			ResponseUtil.write(response,result);
		
	}
	/**
	 * @author wpy
	 * @desc 
	 * @date 2017年1月21日
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/blogBannerSet")
	public  String blogBannerSet(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		return "admin/blogBannerSet";
	}

	@RequestMapping("/addBlogBanner")
	public  String addBlogBanner(HttpServletRequest request, HttpServletResponse response, Model model, String id, MultipartFile pictureFile) throws Exception{
		Blog blog= blogService.getBlogById(Integer.valueOf(id));
		String timeString =String.valueOf(new Date().getTime());
		int a=(int)(Math.random()*10);
		int b=(int)(Math.random()*10);
		timeString = timeString+a+b;
		String originalfileName =pictureFile.getOriginalFilename();
		String newFileName = timeString+originalfileName.substring(originalfileName.lastIndexOf("."));
		//String filePath = request.getContextPath()+"/bannerImages/";
		String filePath =request.getSession().getServletContext().getRealPath("/bannerImages");
		//新文件
		File file = new File(filePath,newFileName);
		//将内存中的文件写入磁盘
		pictureFile.transferTo(file);
		blog.setBannerName(newFileName);
		blog.setBannerFlag(1);
		Map<String, Object> map= new HashMap<>();
		try {
			blogService.updateBlog(blog);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false );
		}
		String result = JSON.toJSONString(map);
		ResponseUtil.write(response,result);
		return null;
	}
	@RequestMapping("/getBanner")
	public  String getBanner(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		List<Blog>  bannerList = blogService.getBanner();
		Map<String,Object> result = new HashMap<>();
		result.put("rows",bannerList);
		result.put("total", 10);
		String json = JSON.toJSONString(result);
		ResponseUtil.write(response, json);
		return null;
	}
	
	@RequestMapping("/updateBanner")
	public  String updateBanner(HttpServletRequest request,HttpServletResponse response,Model model,String id) throws Exception{
		Blog blog = blogService.getBlogById(Integer.valueOf(id));
		model.addAttribute("blog",blog);
		return null;
	}
	
	@RequestMapping("/saveUpdateBlogBanner")
	public  String saveUpdateBlogBanner(HttpServletRequest request, HttpServletResponse response, Model model, String id, MultipartFile pictureFile1) throws Exception{
		Blog blog= blogService.getBlogById(Integer.valueOf(id));
		String timeString =String.valueOf(new Date().getTime());
		int a=(int)(Math.random()*10);
		int b=(int)(Math.random()*10);
		timeString = timeString+a+b;
		String originalfileName =pictureFile1.getOriginalFilename();
		String newFileName = timeString+originalfileName.substring(originalfileName.lastIndexOf("."));
		//String filePath = request.getContextPath()+"/bannerImages/";
		String filePath =request.getSession().getServletContext().getRealPath("/bannerImages");
		//新文件
		File file = new File(filePath,newFileName);
		//将内存中的文件写入磁盘
		pictureFile1.transferTo(file);
		blog.setBannerName(newFileName);
		blog.setBannerFlag(1);
		Map<String, Object> map= new HashMap<>();
		try {
			blogService.updateBlog(blog);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false );
		}
		String result = JSON.toJSONString(map);
		ResponseUtil.write(response,result);
		return null;
	}
	
	@RequestMapping("/deleteBanner")
	public void deleteBanner(HttpServletRequest request,HttpServletResponse response,String ids){
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++){
			Blog blog =	blogService.getBlogById(Integer.valueOf(idsArray[i]));
			blog.setBannerFlag(0);
			blog.setBannerName("");
			blogService.updateBlog(blog);
		}
		
	}

	/**
	 * 跳转到修改关于我界面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/goModifyAboutMe")
	public String goModifyAboutMe(HttpServletRequest request,HttpServletResponse response,Model model){
		Blogger blogger = bloggerService.find();
		model.addAttribute("aboutMe",blogger.getAboutMe());
		return "/admin/modifyAboutMe";

	}

	/**
	 * 保存关于我
	 *
	 * @return
	 */
	@RequestMapping("/saveAboutMe")
	public String saveAboutMe(HttpServletRequest request,HttpServletResponse response,String aboutMe) throws Exception {

		Blogger blogger = bloggerService.find();
		blogger.setAboutMe(aboutMe);
		Map<String,Object> map = new HashMap<>();
        try {
            bloggerService.update(blogger);
            map.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
        }
        String result = JSON.toJSONString(map);
        ResponseUtil.write(response,result);
        return null;
	}

	/**
	 * 跳转到连接管理
	 *
	 * @return
	 */
	@RequestMapping("/linkManage")
	public String linkManage(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		Map<String,Object> map = new HashMap<>();
	 	List<Link> list =linkService.getAllLink(map);
		model.addAttribute("linkList",list);
		return "/admin/linkManage";
	}

	/**
	 * 跳转到连接管理
	 *
	 * @return
	 */
	@RequestMapping("/linkManage")
	public String saveLinkManage(HttpServletRequest request,HttpServletResponse response,Model model,String id,Link link) throws Exception {
		Map<String,Object> map = new HashMap<>();
		try {
			if(id==null || "".equals(id)){
                linkService.addLink(link);
            }else{
                Link link1 =	linkService.getLinkById(Integer.valueOf(id));
                link1.setLinkName(link.getLinkName());
                link1.setLinkUrl(link.getLinkUrl());
                link1.setOrdNo(link.getOrdNo());
                linkService.updateLink(link1);
            }
            map.put("success",true);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			map.put("success",false);
		}
		String result = JSON.toJSONString(map);
		ResponseUtil.write(response,result);
		return null;
	}


}
