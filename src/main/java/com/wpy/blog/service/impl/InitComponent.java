package com.wpy.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.wpy.blog.entity.Blog;
import com.wpy.blog.entity.BlogType;
import com.wpy.blog.entity.Link;
import com.wpy.blog.service.BlogService;
import com.wpy.blog.service.BlogTypeService;
import com.wpy.blog.service.BloggerService;
import com.wpy.blog.service.LinkService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * 进行初始化操作
 */
@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware{

	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext application=servletContextEvent.getServletContext();
		//获取需要调用的服务
		BlogService blogService=(BlogService) applicationContext.getBean("blogService");
		BloggerService bloggerService=(BloggerService) applicationContext.getBean("bloggerService");
		BlogTypeService blogTypeService=(BlogTypeService) applicationContext.getBean("blogTypeService");
		LinkService linkService=(LinkService) applicationContext.getBean("linkService");
		Map<String,Object> map = new HashMap<>();
		// 点击排行
		List<Blog> clickHitRank = blogService.getRankByClickHit();
		application.setAttribute("clickHitRank",clickHitRank);
		//最新文章
		List<Blog> createTimeRank = blogService.getRankByCreateTime();
		application.setAttribute("createTimeRank",createTimeRank);
		//随机文章
		List<Blog> randomBlogs = blogService.getRankByRandom();
		application.setAttribute("randomBlogs",randomBlogs);
		//友情链接
		List<Link> linkList = linkService.getAll(map);
		application.setAttribute("linkList",linkList);
		//标签云（获取所有博客类型）
		List<BlogType> blogTypeList =blogTypeService.getCount(map);
		application.setAttribute("blogTypeList",blogTypeList);
		//博主推荐
		List<Blog> bloggerRecommends = blogService.getBloggerRecommend();
		for(Blog blog:bloggerRecommends){
			List<String> imagesList=blog.getImagesList();
			String blogInfo=blog.getBlogContent();
			Document doc= Jsoup.parse(blogInfo);
			Elements jpgs=doc.select("img[src$=.jpg]"); //　查找扩展名是jpg的图片
			for(int i=0;i<jpgs.size();i++){
				if(i==1){
					break;
				}
				Element jpg=jpgs.get(i);
				imagesList.add(jpg.toString());

			}
		}
		application.setAttribute("bloggerRecommends",bloggerRecommends);
		

	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
