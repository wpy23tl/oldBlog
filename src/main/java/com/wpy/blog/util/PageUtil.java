package com.wpy.blog.util;

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
}


/*
<c:if test="${totalCount}>10">
<div class="page">
	<a title="Total record"><b>总页数</b> </a>
	<c:if test="${currentPage}!=1">
		<a href="/jstt/index.html">&lt;&lt;</a><a href="/jstt/index_3.html">&lt;</a>
	</c:if>
	<c:forEach var="blog" begin="${page}"  step="3">
	 <a href="/jstt/index_3.html">${page}</a>
	
	</c:forEach>
	<c:if test="${currentPage}!=${pageCount}">
		<a href="/jstt/index_5.html">&gt;</a><a href="/jstt/index_6.html">&gt;&gt;</a>
	</c:if>
</div>


 	
</c:if>



<div class="page"><a title="Total record"><b>136</b> </a><a href="/jstt/index.html">&lt;&lt;</a><a href="/jstt/index_3.html">&lt;</a><a href="/jstt/index_2.html">2</a><a href="/jstt/index_3.html">3</a><b>4</b><a href="/jstt/index_5.html">5</a><a href="/jstt/index_6.html">6</a><a href="/jstt/index_5.html">&gt;</a><a href="/jstt/index_6.html">&gt;&gt;</a></div>


*/