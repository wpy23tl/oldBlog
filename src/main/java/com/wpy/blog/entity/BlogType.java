package com.wpy.blog.entity;

public class BlogType {

	private Integer id;//主键id
	private String blogTypeName;//博客类型名字
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBlogTypeName() {
		return blogTypeName;
	}
	public void setBlogTypeName(String blogTypeName) {
		this.blogTypeName = blogTypeName;
	}
	
}
