<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>老王头个人博客</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="${pageContext.request.contextPath}/blogResources/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/blogResources/css/index.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/blogResources/css/learn.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/blogResources/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/blogResources/js/sliders.js"></script>
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<!-- 返回顶部调用 begin -->
<script type="text/javascript" src="js/up/jquery.js"></script>
<script type="text/javascript" src="js/up/js.js"></script>
<!-- 返回顶部调用 end-->
</head>
<body>
<jsp:include page="/common/head.jsp"/>

<article>
  <div class="l_box f_l">
    <div class="banner">
      <div id="slide-holder">
        <div id="slide-runner"> 
        <c:forEach var="bannerBlog" items="${bannerBlogList }">
        	 <a href="${pageContext.request.contextPath}/blog/article.do?id=${bannerBlog.id}" target="_blank"><img id="${bannerBlog.id}" width="100%" src="${pageContext.request.contextPath}/bannerImages/${bannerBlog.bannerName}"  alt="" /></a>
        </c:forEach>
          <div id="slide-controls">
            <p id="slide-client" class="text"><strong></strong><span></span></p>
            <p id="slide-desc" class="text"></p>
            <p id="slide-nav"></p>
          </div>
        </div>
      </div>
      <script>
	  if(!window.slider) {
		var slider={};
	}

	slider.data= [
	   <c:forEach var="bannerBlog" varStatus="stat" items="${bannerBlogList }" >
	   <c:choose>
		<c:when test="${!st.last}">
		{
	        "id":"${bannerBlog.id}", // 与slide-runner中的img标签id对应
	        "client":"",
	        "desc":"${bannerBlog.blogTitle}" //这里修改描述
	    },
		</c:when>
		<c:otherwise>
		{
	        "id":"${bannerBlog.id}", // 与slide-runner中的img标签id对应
	        "client":"标题1",
	        "desc":"这里修改描述 这里修改描述 这里修改描述" //这里修改描述
	    }
		</c:otherwise>
	</c:choose>
	  
	   </c:forEach>
    
	];

	  </script> 
    </div>
    <!-- banner代码 结束 -->
    <div class="topnews">
      <h2><span><a href="/" target="_blank">栏目标题</a><a href="/" target="_blank">栏目标题</a><a href="/" target="_blank">栏目标题</a></span><b>文章</b>推荐</h2>
      <c:forEach var="blog" items="${blogList }" >
	      <div class="blogs">
	        <figure><c:forEach var="image" items="${blog.imagesList }">${image }</c:forEach></figure>
	        <ul>
	          <h3><a href="${pageContext.request.contextPath}/blog/article.do?id=${blog.id}">${blog.blogTitle}</a></h3>
	          <p>${blog.summary }......</p>
	          <p class="autor"><span class="lm f_l"><a href="/">${blog.blogTypeName}</a></span><span class="dtime f_l">${blog.createTime}</span><span class="viewnum f_r">浏览（<a href="/">${blog.clickHit }</a>）</span><span class="pingl f_r">评论（<a href="/">30</a>）</span></p>
	        </ul>
	      </div>
      </c:forEach>
     
     ${pageCode }
    
    </div>
  </div>
  <div class="r_box f_r">
    <div class="tit01">
      <h3>关注我</h3>
      <div class="gzwm">
        <ul>
          <li><a class="xlwb" href="#" target="_blank">新浪微博</a></li>
          <li><a class="txwb" href="#" target="_blank">腾讯微博</a></li>
          <li><a class="rss" href="portal.php?mod=rss" target="_blank">RSS</a></li>
          <li><a class="wx" href="mailto:admin@admin.com">邮箱</a></li>
        </ul>
      </div>
    </div>
    <!--tit01 end-->
    <div class="ad300x100"> <img src="${pageContext.request.contextPath}/blogResources/images/ad300x100.jpg"> </div>
    <div class="moreSelect" id="lp_right_select"> 
      <script>
window.onload = function ()
{
	var oLi = document.getElementById("tab").getElementsByTagName("li");
	var oUl = document.getElementById("ms-main").getElementsByTagName("div");
	
	for(var i = 0; i < oLi.length; i++)
	{
		oLi[i].index = i;
		oLi[i].onmouseover = function ()
		{
			for(var n = 0; n < oLi.length; n++) oLi[n].className="";
			this.className = "cur";
			for(var n = 0; n < oUl.length; n++) oUl[n].style.display = "none";
			oUl[this.index].style.display = "block"
		}	
	}
}
</script>
      <div class="ms-top">
        <ul class="hd" id="tab">
          <li class="cur"><a href="/">点击排行</a></li>
          <li><a href="/">最新文章</a></li>
          <li><a href="/">随机文章</a></li>
        </ul>
      </div>
      <div class="ms-main" id="ms-main">
        <div style="display: block;" class="bd bd-news" >
          <ul>
          	<c:forEach var="clickRank" items="${clickHitRank }">
          		<li><a href="${pageContext.request.contextPath}/blog/article.do?id=${clickRank.id}" target="_blank">${clickRank.blogTitle}</a></li>
          	</c:forEach>
          </ul>
        </div>
        <div  class="bd bd-news">
          <ul>
          <c:forEach var="createRank" items="${createTimeRank}">
          		<li><a href="${pageContext.request.contextPath}/blog/article.do?id=${createRank.id}" target="_blank">${createRank.blogTitle}</a></li>
          	</c:forEach>
          </ul>
        </div>
        <div class="bd bd-news">
          <ul>
          <c:forEach var="random" items="${randomBlogs}">
          		<li><a href="${pageContext.request.contextPath}/blog/article.do?id=${random.id}" target="_blank">${random.blogTitle}</a></li>
          	</c:forEach>
          </ul>
        </div>
      </div>
      <!--ms-main end --> 
    </div>
    <!--切换卡 moreSelect end -->
    
    <div class="cloud">
      <h3>标签云</h3>
      <ul>
       <c:forEach var="blogType" items="${blogTypeList}" varStatus="stat">
       	<li><a href="${pageContext.request.contextPath}/blog/index.do?blogTypeId=${blogType.id}">${blogType.blogTypeName}(${blogType.blogTypeCount })</a></li>
       </c:forEach>
      </ul>
    </div>
    <div class="tuwen">
      <h3>博主推荐</h3>
      <ul>
      <c:forEach var="recommend" items="${bloggerRecommends}">
       	<li><a href="${pageContext.request.contextPath}/blog/article.do?id=${recommend.id}"><c:forEach var="image" items="${recommend.imagesList }">${image }</c:forEach><b>${recommend.blogTitle }</b></a>
          <p><span class="tulanmu"><a href="/">${recommend.blogTypeName}</a></span><span class="tutime"><fmt:formatDate value="${recommend.createTime}" pattern="yyyy-MM-dd" /></span></p>
        </li>
       </c:forEach>
      </ul>
    </div>
    <div class="ad"> <img src="${pageContext.request.contextPath}/blogResources/images/03.jpg"> </div>
    <div class="links">
      <h3><span>[<a href="/">申请友情链接</a>]</span>友情链接</h3>
      <ul>
        <li><a href="/">杨青个人博客</a></li>
        <li><a href="/">web开发</a></li>
        <li><a href="/">前端设计</a></li>
        <li><a href="/">Html</a></li>
        <li><a href="/">CSS3</a></li>
        <li><a href="/">Html5+css3</a></li>
        <li><a href="/">百度</a></li>
      </ul>
    </div>
  </div>
  <!--r_box end --> 

</article>

<jsp:include page="/common/foot.jsp"/>
</body>
</html>
