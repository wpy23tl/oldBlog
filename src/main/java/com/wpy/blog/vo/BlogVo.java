package com.wpy.blog.vo;

import java.util.Date;

public class BlogVo {

	private Integer id;//����id
	private String blogTitle;//���ͱ���
	private String blogContent;//��������
	private String createTime;//����ʱ��
	private String updateTime;//�޸�ʱ��
	private Integer blogTypeId;//��������id
	private String blogTypeName;
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
	public String getBlogTypeName() {
		return blogTypeName;
	}
	public void setBlogTypeName(String blogTypeName) {
		this.blogTypeName = blogTypeName;
	}
	
	
}
