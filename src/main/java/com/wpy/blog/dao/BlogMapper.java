package com.wpy.blog.dao;

import com.github.abel533.mapper.Mapper;
import com.wpy.blog.entity.Blog;

import java.util.List;

public interface BlogMapper extends Mapper<Blog> {

    /**
     * 查询当前表所有数据
     * @param id
     * @return
     */
    List<Blog> selectAll();
}