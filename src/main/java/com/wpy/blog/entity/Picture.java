package com.wpy.blog.entity;

import java.io.Serializable;
public class Picture implements Serializable{

	private int id;//主键id
	private String  path;//图片路径

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
