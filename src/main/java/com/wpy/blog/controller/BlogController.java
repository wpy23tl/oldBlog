package com.wpy.blog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wpy.blog.entity.*;
import com.wpy.blog.service.LinkService;
import com.wpy.blog.service.PictureService;
import com.wpy.blog.util.EhcacheUtil;
import net.sf.ehcache.Cache;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@Resource
	private LinkService linkService;
	@Resource
	private EhcacheUtil ehcacheUtil;
	@Resource
	private PictureService pictureService;

	public Cache cache ;
	public List<BlogType> blogTypeList;
	public 	List<Blog> bannerBlogList;
	public List<BlogVo> newBlogList;
	public Integer totalCount = null;


	@ModelAttribute
	public void init(Model model){
		Map<String,Object> map = new HashMap<>();
		// 点击排行
		List<Blog> clickHitRank = blogService.getRankByClickHit();
		//application.setAttribute("clickHitRank",clickHitRank);
		model.addAttribute("clickHitRank",clickHitRank);
		//最新文章
		List<Blog> createTimeRank = blogService.getRankByCreateTime();
		//application.setAttribute("createTimeRank",createTimeRank);
		model.addAttribute("createTimeRank",createTimeRank);
		//随机文章
		List<Blog> randomBlogs = blogService.getRankByRandom();
		//application.setAttribute("randomBlogs",randomBlogs);
		model.addAttribute("randomBlogs",randomBlogs);
		//友情链接
		List<Link> linkList = linkService.getAll(map);
		model.addAttribute("linkList",linkList);
		//application.setAttribute("linkList",linkList);
		//标签云（获取所有博客类型）
		List<BlogType> blogTypeList =blogTypeService.getCount(map);
		model.addAttribute("blogTypeList",blogTypeList);
		//application.setAttribute("blogTypeList",blogTypeList);
		//博主推荐
		List<Blog> bloggerRecommends = blogService.getBloggerRecommend();
		List<BlogVo> newBloggerRecommends = new ArrayList<>();
		for(Blog blog:bloggerRecommends){
			Picture picture = pictureService.getBlogById(blog.getArticlePictureViewId());
			BlogVo blogVo = new BlogVo();
			BeanUtils.copyProperties(blog, blogVo);
			if (picture!=null){
				String picturePath = picture.getPath();
				blogVo.setPath(picturePath);
			}
			newBloggerRecommends.add(blogVo);
		}
		model.addAttribute("bloggerRecommends",newBloggerRecommends);
	}

	/**
	 * @author wpy
	 * @description 进入博客前台页面
	 * @date 2017年1月11日
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
//	@RequestMapping("/index")
//	public String index(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam(value="page",required=false)String page,
//			@RequestParam(value="rows",required=false)String pageSize,String blogTypeId){
//		Map<String,Object> map = new HashMap<>();
//		//获取所有博客类型
//		if("".equals(page) || page==null){
//			page="1";
//		}
//		if("".equals(pageSize) || pageSize==null){
//			pageSize="10";
//		}
//
//		PageBean pageBean = new PageBean(Integer.valueOf(page),Integer.valueOf(pageSize));
//		map.put("start", pageBean.getStart());
//		map.put("size", pageBean.getPageSize());
//		if(blogTypeId!=null && !"null".equals(blogTypeId) ){
//			map.put("blogTypeId",Integer.valueOf(blogTypeId));
//		}
//		Map<String,Object> map0 = new HashMap<>();
//		List<BlogType> blogTypeList =blogTypeService.getCount(map0);
//		model.addAttribute("blogTypeList",blogTypeList);
//		//获取所有博客
//		List<Blog> blogList =  blogService.getAll(map);
//		List<BlogVo> newBlogList = new ArrayList<>();
//		for(Blog blog:blogList){
//			Date createTime = blog.getCreateTime();
//			String createTimeString = DateTimeUtil.DateToString(createTime, "yyyy-MM-dd HH:mm:ss");
//			BlogVo blogVo = new BlogVo();
//			BeanUtils.copyProperties(blog, blogVo);
//			blogVo.setCreateTime(createTimeString);
//			newBlogList.add(blogVo);
//		}
//
//
//		//获取所有banner
//		List<Blog> bannerBlogList = blogService.getBanner();
//		model.addAttribute("bannerBlogList",bannerBlogList);
//		//获取博客总数
//		Integer totalCount = null;
//		if(blogTypeId==null || "".equals(blogTypeId) || "null".equals(blogTypeId)){
//			totalCount = blogService.getTotalCount();
//		}else{
//			Map<String,Object> map1 = new HashMap<>();
//			map1.put("id",blogTypeId);
//			List<BlogType> blogTypeList1 = blogTypeService.getCount(map1);
//			BlogType blogType = blogTypeList1.get(0);
//			totalCount= blogType.getBlogTypeCount();
//		}
//		for(BlogVo blog:newBlogList){
//			List<String> imagesList=blog.getImagesList();
//			String blogInfo=blog.getBlogContent();
//			Document doc=Jsoup.parse(blogInfo);
//			Elements jpgs=doc.select("img[src$=.jpg]"); //　查找扩展名是jpg的图片
//			for(int i=0;i<jpgs.size();i++){
//				if(i==1){
//					break;
//				}
//				Element jpg=jpgs.get(i);
//				imagesList.add(jpg.toString());
//
//			}
//		}
//
//		model.addAttribute("blogList",newBlogList);
//
//		String pageCode = PageUtil.genPageCode(totalCount, Integer.valueOf(pageSize),Integer.valueOf(page), blogTypeId, request);
//		model.addAttribute("pageCode",pageCode);
//		return "portal/index";
//	}

	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam(value="page",required=false)String page,
						@RequestParam(value="rows",required=false)String pageSize,String blogTypeId){
		Map<String,Object> map = new HashMap<>();
		//获取所有博客类型
		if("".equals(page) || page==null){
			page="1";
		}
		if("".equals(pageSize) || pageSize==null){
			pageSize="10";
		}

		PageBean pageBean = new PageBean(Integer.valueOf(page),Integer.valueOf(pageSize));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		if(blogTypeId!=null && !"null".equals(blogTypeId) ){
			map.put("blogTypeId",Integer.valueOf(blogTypeId));
		}
		Map<String,Object> map0 = new HashMap<>();
		List<BlogType> blogTypeList =blogTypeService.getCount(map0);
		model.addAttribute("blogTypeList",blogTypeList);
		//获取所有博客
		List<Blog> blogList =  blogService.getAll(map);
		List<BlogVo> newBlogList = new ArrayList<>();
		for(Blog blog:blogList){
			Date createTime = blog.getCreateTime();
			String createTimeString = DateTimeUtil.DateToString(createTime, "yyyy-MM-dd HH:mm:ss");
			BlogVo blogVo = new BlogVo();
			BeanUtils.copyProperties(blog, blogVo);
			blogVo.setCreateTime(createTimeString);
			Picture picture = pictureService.getBlogById(blog.getArticlePictureViewId());
			if (picture!=null){
				String picturePath = picture.getPath();
				blogVo.setPath(picturePath);
			}
			newBlogList.add(blogVo);
		}


		//获取所有banner
		List<Blog> bannerBlogList = blogService.getBanner();
		model.addAttribute("bannerBlogList",bannerBlogList);
		//获取博客总数
		Integer totalCount = null;
		if(blogTypeId==null || "".equals(blogTypeId) || "null".equals(blogTypeId)){
			totalCount = blogService.getTotalCount();
		}else{
			Map<String,Object> map1 = new HashMap<>();
			map1.put("id",blogTypeId);
			List<BlogType> blogTypeList1 = blogTypeService.getCount(map1);
			BlogType blogType = blogTypeList1.get(0);
			totalCount= blogType.getBlogTypeCount();
		}
//		for(BlogVo blog:newBlogList){
//			List<String> imagesList=blog.getImagesList();
//			String blogInfo=blog.getBlogContent();
//			Document doc=Jsoup.parse(blogInfo);
//			Elements jpgs=doc.select("img[src$=.jpg]"); //　查找扩展名是jpg的图片
//			for(int i=0;i<jpgs.size();i++){
//				if(i==1){
//					break;
//				}
//				Element jpg=jpgs.get(i);
//				imagesList.add(jpg.toString());
//
//			}
//		}

		model.addAttribute("blogList",newBlogList);

		String pageCode = PageUtil.genPageCode(totalCount, Integer.valueOf(pageSize),Integer.valueOf(page), blogTypeId, request);
		model.addAttribute("pageCode",pageCode);
		return "portal/index";
	}

//	@RequestMapping("/index")
//	public String index(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam(value="page",required=false)String page,
//						@RequestParam(value="rows",required=false)String pageSize,String blogTypeId){
//		Map<String,Object> map = new HashMap<>();
//		//获取所有博客类型
//		if("".equals(page) || page==null){
//			page="1";
//		}
//		if("".equals(pageSize) || pageSize==null){
//			pageSize="10";
//		}
//
//		PageBean pageBean = new PageBean(Integer.valueOf(page),Integer.valueOf(pageSize));
//		map.put("start", pageBean.getStart());
//		map.put("size", pageBean.getPageSize());
//		if(blogTypeId!=null && !"null".equals(blogTypeId) ){
//			map.put("blogTypeId",Integer.valueOf(blogTypeId));
//		}
//		//判断缓存是否存在
//		if (ehcacheUtil.get("sampleCache1","bannerBlogList")==null){
//			Map<String,Object> map0 = new HashMap<>();
//			List<BlogType> blogTypeList =blogTypeService.getCount(map0);
//			ehcacheUtil.put("sampleCache1","blogTypeList",blogTypeList);
//			model.addAttribute("blogTypeList",blogTypeList);
//			//获取所有博客
//			List<Blog> blogList =  blogService.getAll(map);
//			List<BlogVo> newBlogList = new ArrayList<>();
//			for(Blog blog:blogList){
//				Date createTime = blog.getCreateTime();
//				String createTimeString = DateTimeUtil.DateToString(createTime, "yyyy-MM-dd HH:mm:ss");
//				BlogVo blogVo = new BlogVo();
//				BeanUtils.copyProperties(blog, blogVo);
//				blogVo.setCreateTime(createTimeString);
//				newBlogList.add(blogVo);
//			}
//
//
//			//获取所有banner
//			List<Blog> bannerBlogList = blogService.getBanner();
//			ehcacheUtil.put("sampleCache1","bannerBlogList",bannerBlogList);
//			model.addAttribute("bannerBlogList",bannerBlogList);
//			//获取博客总数
//			 totalCount = null;
//			if(blogTypeId==null || "".equals(blogTypeId) || "null".equals(blogTypeId)){
//				totalCount = blogService.getTotalCount();
//                ehcacheUtil.put("sampleCache1","totalCount",totalCount);
//			}else{
//				Map<String,Object> map1 = new HashMap<>();
//				map1.put("id",blogTypeId);
//				List<BlogType> blogTypeList1 = blogTypeService.getCount(map1);
//				BlogType blogType = blogTypeList1.get(0);
//				totalCount= blogType.getBlogTypeCount();
//                ehcacheUtil.put("sampleCache1","totalCount",totalCount);
//			}
//			for(BlogVo blog:newBlogList){
//				List<String> imagesList=blog.getImagesList();
//				String blogInfo=blog.getBlogContent();
//				Document doc=Jsoup.parse(blogInfo);
//				Elements jpgs=doc.select("img[src$=.jpg]"); //　查找扩展名是jpg的图片
//				for(int i=0;i<jpgs.size();i++){
//					if(i==1){
//						break;
//					}
//					Element jpg=jpgs.get(i);
//					imagesList.add(jpg.toString());
//
//				}
//			}
//			ehcacheUtil.put("sampleCache1","blogList",newBlogList);
//			model.addAttribute("blogList",newBlogList);
//		}else{
//            totalCount = (Integer)ehcacheUtil.get("sampleCache1","totalCount");
//			//获取banner
//			bannerBlogList=(List<Blog>)ehcacheUtil.get("sampleCache1","bannerBlogList");
//			model.addAttribute("bannerBlogList",bannerBlogList);
//			//获取所有博客
//			newBlogList=(List<BlogVo>)ehcacheUtil.get("sampleCache1","blogList");
//			model.addAttribute("blogList",newBlogList);
//
//
//		}
//
//
//		String pageCode = PageUtil.genPageCode(totalCount, Integer.valueOf(pageSize),Integer.valueOf(page), blogTypeId, request);
//		model.addAttribute("pageCode",pageCode);
//		return "portal/index";
//	}

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
	public String article(HttpServletRequest request,HttpServletResponse response,Model model,String id,String blogTypeId){
		Map<String,Object> map = new HashMap<>();
//		//获取所有博客类型
//		List<BlogType> blogTypeList = blogTypeService.getAllBlogType(map);
//		model.addAttribute("blogTypeList",blogTypeList);
		//获取所有博客
		List<Blog> blogList =  blogService.getAll(map);
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
		//增加查看次数
		blog.setClickHit(blog.getClickHit()+1);
		blogService.update(blog);
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
		


		if(blogTypeId!=null && !"null".equals(blogTypeId) ){
			map.put("blogTypeId",Integer.valueOf(blogTypeId));
		}
		Map<String,Object> map0 = new HashMap<>();
		List<BlogType> blogTypeList =blogTypeService.getCount(map0);
		model.addAttribute("blogTypeList",blogTypeList);
		return "portal/article";
	}
}
