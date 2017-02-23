package com.wpy.blog.service.impl;

import com.wpy.blog.dao.LinkDao;
import com.wpy.blog.entity.Link;
import com.wpy.blog.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wlx on 2017/2/14.
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Resource
    private LinkDao linkDao;
    @Override
    public void add(Link link) {
         linkDao.insert(link);
    }

    @Override
    public void update(Link link) {
        linkDao.updateByPrimaryKey(link);
    }

    @Override
    public void delete(Integer id) {
        linkDao.deleteByPrimarKey(id);
    }

    @Override
    public Link getLinkById(Integer id) {
        return linkDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Link> getAll(Map<String, Object> map) {
        return linkDao.selectAll(map);
    }

    @Override
    public Integer getTotalCount() {
        return linkDao.getTotalCount();
    }

    @Override
    public List<Link> getCount(Map<String, Object> map) {
        return null;
    }
}
