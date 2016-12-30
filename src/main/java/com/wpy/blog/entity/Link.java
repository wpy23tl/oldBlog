package com.wpy.blog.entity;

public class Link {

	private Integer id;//主键id
	private String linkName;//友情链接名称
	private String linkPath;//友情链接路径
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkPath() {
		return linkPath;
	}
	public void setLinkPath(String linkPath) {
		this.linkPath = linkPath;
	}
	
}
