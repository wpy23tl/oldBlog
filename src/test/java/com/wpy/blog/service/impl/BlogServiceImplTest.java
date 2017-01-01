package com.wpy.blog.service.impl;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wpy.blog.entity.Blog;
import com.wpy.blog.service.BlogService;

public class BlogServiceImplTest {

	@Test
	public void testAddBlog() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BlogService blogService = (BlogService)ac.getBean("blogService");
		Blog blog = new Blog();
		blog.setId(null);
		blog.setBlogTitle("发的顺丰到付");
		blog.setUpdateTime(new Date());
		blog.setUpdateTime(new Date());
		blog.setBlogContent("违法打发第三方第三方士大夫打发打发");
		blog.setBlogTypeId(Integer.valueOf(23));
		blogService.addBlog(blog);
		System.out.println("------------");
	}

//	@Test
//	public void testUpdateBlog() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteBlog() {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		BlogService blogService = (BlogService)ac.getBean("blogService");
//		blogService.deleteBlog(Integer.valueOf(1));
//		System.out.println("------------");
//	}
//
//	@Test
//	public void testGetBlogById() {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		BlogService blogService = (BlogService)ac.getBean("blogService");
//		Blog blog =blogService.getBlogById(Integer.valueOf(1));
//		System.out.println("------------");
//		System.out.println(blog.toString());
//	}

//	@Test
//	public void testGetAllBlog() {
//		fail("Not yet implemented");
//	}

}
