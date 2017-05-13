package com.wpy.blog.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wpy.blog.entity.*;
import com.wpy.blog.service.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
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
	@Resource
	private PictureService pictureService;
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
		List<Blog> blogList=blogService.getAll(map);
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
			blogService.delete(Integer.valueOf(idsArray[i]));
		}
		
		
	}
	
	@RequestMapping("/addBlog")
	public String writeBlog(HttpServletRequest request,HttpServletResponse response,Model model){
		Map<String,Object> map=new HashMap<String,Object>();
		List<BlogType> blogTypeList = blogTypeService.getAll(map);
		model.addAttribute("blogTypeList",blogTypeList);
		return "admin/blogAdd2";
	}
	
	@RequestMapping("/saveBlog")
	public String saveBlog(HttpServletRequest request,HttpServletResponse response,Model model,Blog blog) throws Exception {
		Map<String, Object> map = new HashMap<>();
		//解析首张图片名称，保存到图片表
		String blogInfo = blog.getBlogContent();
		Document doc = Jsoup.parse(blogInfo);
		Elements jpgs = doc.select("img[src$=.jpg]"); //　查找扩展名是jpg的图片
		//String title = doc.select("img[src$=.jpg]").get(0).attr("title"); //　查找扩展名是jpg的图片
		Integer pictureViewId = null;
		for(int i=0;i<jpgs.size();i++){
			if(i==1){
				break;
			}
			Element jpg=jpgs.get(i);
			//获得图片名
			String jpgTitle = jpg.attr("title");
			String oldPath = jpg.attr("src");
			if(jpgTitle!=null && !("").equals(jpgTitle)){
				//插入图片表
				Picture picture = new Picture();
				picture.setPath(jpgTitle);
				pictureService.add(picture);
				 pictureViewId = Integer.valueOf(picture.getId());
			}
			movePictureLocation(request,oldPath,jpgTitle);
			//String jpgString =jpg.toString();
		}


		 try {
			 if("".equals(blog.getId()) || null == blog.getId()){
				 blog.setArticlePictureViewId(pictureViewId);
				 blogService.add(blog);
			 }else{
				 Blog blog1 = blogService.getBlogById(blog.getId());
				 blog1.setBlogContent(blog.getBlogContent());
				 blog1.setBlogTitle(blog.getBlogTitle());
				 blog1.setBlogTypeId(blog.getBlogTypeId());
				 blog1.setUpdateTime(new Date());
				 blog1.setArticlePictureViewId(pictureViewId);
				 blogService.update(blog1);
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
		List<BlogType> blogTypeList=blogTypeService.getAll(map);
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
			blogService.update(blog);
		}
		
	}
	
	@RequestMapping("/addRecommendBlog")
	public void addRecommendBlog(HttpServletRequest request,HttpServletResponse response,String ids){
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++){
			Blog blog = blogService.getBlogById(Integer.valueOf(idsArray[i]));
			blog.setRecommendFlag(1);
			blogService.update(blog);
		}
		
	}
	
	@RequestMapping("/updateRecommendBlog")
	public void updateRecommendBlog(HttpServletRequest request,HttpServletResponse response,String id,String recommendNo) throws Exception{
			Map<String, Object> map= new HashMap<>();
			Blog blog = blogService.getBlogById(Integer.valueOf(id));
			blog.setRecommendNo(Integer.valueOf(recommendNo));
			try {
				blog.setRecommendNo(Integer.valueOf(recommendNo));
				blogService.update(blog);
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
			blogService.update(blog);
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
			blogService.update(blog);
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
			blogService.update(blog);
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
		return "/admin/linkManage";
	}

	/**
	 * 跳转到连接管理
	 *
	 * @return
	 */
	@RequestMapping("/linkList")
	public String linkList(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		Map<String,Object> map = new HashMap<>();
		List<Link> list =linkService.getAll(map);
		Map<String,Object> result = new HashMap<>();
		result.put("rows",list);
		result.put("total", 50);
		String json = JSON.toJSONString(result);
		ResponseUtil.write(response, json);
		return null;
	}

	/**
	 * 跳转到连接管理
	 *
	 * @return
	 */
	@RequestMapping("/saveLinkManage")
	public String saveLinkManage(HttpServletRequest request,HttpServletResponse response,Model model,String id,Link link) throws Exception {
		Map<String,Object> map = new HashMap<>();
		try {
			if(id==null || "".equals(id)){
                linkService.add(link);
            }else{
                Link link1 =linkService.getLinkById(Integer.valueOf(id));
                link1.setLinkName(link.getLinkName());
                link1.setLinkUrl(link.getLinkUrl());
                link1.setOrdNo(link.getOrdNo());
                linkService.update(link1);
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

	@RequestMapping("/deleteLink")
	public String deleteLink(HttpServletRequest request,HttpServletResponse response,Model model,String ids) throws Exception {
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++){
			linkService.delete(Integer.valueOf(idsArray[i]));
		}
		return null;
	}

	/**
	 * 跳转到文章图片预览设置界面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/articlePictureViewSet")
	public  String articlePictureViewSet(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		return "admin/articlePictureViewSet";
	}

	@RequestMapping("/saveArticlePictureViewSet")
	public  String saveArticlePictureViewSet(HttpServletRequest request, HttpServletResponse response, Model model, String id, MultipartFile pictureFile1) throws Exception{
		Blog blog= blogService.getBlogById(Integer.valueOf(id));
		String timeString =String.valueOf(new Date().getTime());
		int a=(int)(Math.random()*10);
		int b=(int)(Math.random()*10);
		timeString = timeString+a+b;
		String originalfileName =pictureFile1.getOriginalFilename();
		String newFileName = timeString+originalfileName.substring(originalfileName.lastIndexOf("."));
		String filePath =request.getSession().getServletContext().getRealPath("/articlePictureView");
		//新文件
		File file = new File(filePath,newFileName);
		//将内存中的文件写入磁盘
		pictureFile1.transferTo(file);
		//将路径存入图片表
		Picture picture = new Picture();
		picture.setPath(newFileName);
		pictureService.add(picture);
		int pictureId = picture.getId();
		blog.setArticlePictureViewId(pictureId);
		Map<String, Object> map= new HashMap<>();
		try {
			blogService.update(blog);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false );
		}
		String result = JSON.toJSONString(map);
		ResponseUtil.write(response,result);
		return null;
	}

	/**
	 * 移动图片初始位置到指定位置
	 * @param originalLocation 图片初始位置
	 * @return
	 */
	public  void movePictureLocation  (HttpServletRequest request,String oldPath,String newPath) throws Exception {

		String oldPath1 = oldPath.substring(5);
		String filePath =request.getSession().getServletContext().getRealPath(oldPath1);
		// 封装数据源
		FileInputStream fis = new FileInputStream(filePath);

		String filePath1 =request.getSession().getServletContext().getRealPath("/articlePictureView")+"/"+newPath;

		// 封装目的地
		FileOutputStream fos = new FileOutputStream(filePath1);

		//复制数据
		int by = 0;
		while ((by = fis.read()) != -1){
			fos.write(by);
		}

		//释放资源
		fos.close();
		fis.close();
	}

}
