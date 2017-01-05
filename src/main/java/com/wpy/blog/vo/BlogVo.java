package com.wpy.blog.vo;

import java.util.Date;

public class BlogVo {

	private Integer id;//主键id
	private String blogTitle;//博客标题
	private String blogContent;//博客内容
	private String createTime;//创建时间
	private String updateTime;//修改时间
	private Integer blogTypeId;//博客类型id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getBlogTypeId() {
		return blogTypeId;
	}
	public void setBlogTypeId(Integer blogTypeId) {
		this.blogTypeId = blogTypeId;
	}
	
	
}
