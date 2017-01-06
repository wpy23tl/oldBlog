package com.wpy.blog.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wpy.blog.entity.BlogType;
import com.wpy.blog.service.BlogTypeService;

public class BlogTypeServiceImplTest {

	@Test
	public void testGetAllBlogType() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BlogTypeService blogTypeService = (BlogTypeService)ac.getBean("blogTypeService");
		 blogTypeService.getAllBlogType();
		System.out.println("-----------");
	}

}
