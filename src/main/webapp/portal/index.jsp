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
<header>
  <div class="logo f_l"> <a href="/"><img src="${pageContext.request.contextPath}/blogResources/images/logo.png"></a> </div>
  <nav id="topnav" class="f_r">
    <ul>
      <a href="index.html" target="_blank">首页</a> <a href="news.html" target="_blank">关于我</a> <a href="p.html" target="_blank">文章</a> <a href="a.html" target="_blank">心情</a> <a href="c.html" target="_blank">相册</a> <a href="b.html" target="_blank">留言</a>
    </ul>
    <script src="js/nav.js"></script> 
  </nav>
</header>
<article>
  <div class="l_box f_l">
    <div class="banner">
      <div id="slide-holder">
        <div id="slide-runner"> <a href="/" target="_blank"><img id="slide-img-1" src="${pageContext.request.contextPath}/blogResources/images/a1.jpg"  alt="" /></a> <a href="/" target="_blank"><img id="slide-img-2" src="${pageContext.request.contextPath}/blogResources/images/a2.jpg"  alt="" /></a> <a href="/" target="_blank"><img id="slide-img-3" src="${pageContext.request.contextPath}/blogResources/images/a3.jpg"  alt="" /></a> <a href="/" target="_blank"><img id="slide-img-4" src="${pageContext.request.contextPath}/blogResources/images/a4.jpg"  alt="" /></a>
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
    {
        "id":"slide-img-1", // 与slide-runner中的img标签id对应
        "client":"标题1",
        "desc":"这里修改描述 这里修改描述 这里修改描述" //这里修改描述
    },
    {
        "id":"slide-img-2",
        "client":"标题2",
        "desc":"add your description here"
    },
    {
        "id":"slide-img-3",
        "client":"标题3",
        "desc":"add your description here"
    },
    {
        "id":"slide-img-4",
        "client":"标题4",
        "desc":"add your description here"
    } 
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
          		<li><a href="/" target="_blank">${clickRank.blogTitle}</a></li>
          	</c:forEach>
          </ul>
        </div>
        <div  class="bd bd-news">
          <ul>
          <c:forEach var="createRank" items="${createTimeRank}">
          		<li><a href="/" target="_blank">${createRank.blogTitle}</a></li>
          	</c:forEach>
          </ul>
        </div>
        <div class="bd bd-news">
          <ul>
          <c:forEach var="random" items="${randomBlogs}">
          		<li><a href="/" target="_blank">${random.blogTitle}</a></li>
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
       <c:forEach var="blogType" items="${blogTypeList}">
       	<li><a href="/">${blogType.blogTypeName}</a></li>
       </c:forEach>
      </ul>
    </div>
    <div class="tuwen">
      <h3>博主推荐</h3>
      <ul>
      <c:forEach var="recommend" items="${bloggerRecommends}">
       	<li><a href="/"><img src="${pageContext.request.contextPath}/blogResources/images/01.jpg"><b>${recommend.blogTitle }</b></a>
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

<footer>
  <p class="ft-copyright">老王头博客 Design by 老王头 </p>
  <div id="tbox"> <a id="togbook" href="/"></a> <a id="gotop" href="javascript:void(0)"></a> </div>
</footer>
</body>
</html>
