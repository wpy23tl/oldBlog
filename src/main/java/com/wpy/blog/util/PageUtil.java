package com.wpy.blog.util;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {

	/**
	 * @author wpy
	 * @desc 根据总记录数与每页条目获取总页数
	 * @date 2017年1月17日
	 * @param totalCount
	 * @param pageSize
	 * @return
	 */
	public static Integer getPageCount(Integer totalCount,Integer pageSize){
		Integer pageCount=null;
		
		if(totalCount%pageSize==0){
			pageCount = totalCount/pageSize;
		}else{
			pageCount = totalCount/pageSize+1;
		}
		return pageCount;
	}
	
	public static String genPageCode(Integer totalCount,Integer pageSize,Integer currentPage,HttpServletRequest request){
Integer pageCount=null;
		
		if(totalCount%pageSize==0){
			pageCount = totalCount/pageSize;
		}else{
			pageCount = totalCount/pageSize+1;
		}
		StringBuffer sb = new StringBuffer();
		
		String projectName =request.getContextPath();
		if(totalCount>10){
			sb.append("<div class='page'><a title='Total record'><b>"+pageCount+"</b> </a>");
			if(currentPage!=1){
				sb.append("<a href='"+projectName+"/blog/index.do'>&lt;&lt;</a><a href='"+projectName+"/blog/index.do?page="+(currentPage-1)+"'>&lt;</a>");
			}
			for(int i=currentPage-2;i<=currentPage+2;i++){
				if(i<1||i>pageCount){
					continue;
				}
				if(i==currentPage){
					sb.append("<b>"+currentPage+"</b>");	
				}else{
					sb.append("<a href='"+projectName+"/blog/index.do?page="+i+"'>"+i+"</a>");	
				}
			}
			if(currentPage!=pageCount){
				sb.append("<a href='"+projectName+"/blog/index.do?page="+(currentPage+1)+"'>&gt;</a><a href='"+projectName+"/blog/index.do?page="+pageCount+"'>&gt;&gt;</a>");
			}
			sb.append("</div>");
		}
		return sb.toString();
	}
}

