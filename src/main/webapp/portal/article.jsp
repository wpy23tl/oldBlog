<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>兔小白个人博客</title>
<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="${pageContext.request.contextPath}/blogResources/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/blogResources/css/index.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/blogResources/newcss/new.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/blogResources/newcss/embed.default.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/blogResources/newcss/lrtk.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/blogResources/newcss/share_style1_32.css" rel="stylesheet">

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
    <h2 class="c_titile">${blog.blogTitle}</h2>
    <p class="box_c"><span class="d_time">发布时间：${blog.createTime}</span><span>编辑：<a href="mailto:dancesmiling@qq.com">杨青</a></span><span>阅读（<script src="/e/public/ViewClick/?classid=8&amp;id=530&amp;addclick=1"></script>90800）</span></p>
    <ul class="infos">
		${blog.blogContent}
    </ul>
    <div class="keybq">
    <p><span>关键字词</span>：学习,web,前端开发,web前端,学习web前端</p>    
    </div>
    <div class="ad"><script type="text/javascript">
/*自定义标签云myqq，创建于2013-8-2*/
var cpro_id = "u1335521";
</script>
<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>

</div>
    <div class="nextinfo">
<p>上一篇：<c:choose><c:when test="${not empty lastBlog.id}"><a href="${pageContext.request.contextPath}/blog/article.do?id=${lastBlog.id}">${lastBlog.blogTitle }</a></c:when><c:otherwise>没有了</c:otherwise>  </c:choose></p>
<p>下一篇：<c:choose><c:when test="${not empty nextBlog.id}"><a href="${pageContext.request.contextPath}/blog/article.do?id=${nextBlog.id}">${nextBlog.blogTitle }</a></c:when><c:otherwise>没有了</c:otherwise>  </c:choose></p>
    </div>
    <div class="otherlink">
      <h2>相关文章</h2>
      <ul>
 <li><a href="/jstt/css3/2014-05-12/664.html" title="关于响应式Web设计技巧以及入门">关于响应式Web设计技巧以及入门</a></li><li><a href="/news/s/2013-09-04/606.html" title="程序员应该如何高效的工作学习">程序员应该如何高效的工作学习</a></li><li><a href="http://www.bestcssbuttongenerator.com" title="Webarti CSS3 Button Maker">Webarti CSS3 Button Maker</a></li><li><a href="/jstt/css3/2013-07-10/370.html" title="html5 css3 web标准基础教程入门">html5 css3 web标准基础教程入门</a></li><li><a href="/jstt/css3/2013-07-07/363.html" title="学习Html5建站教程（一）Html5简介">学习Html5建站教程（一）Html5简介</a></li><li><a href="/jstt/css3/2013-07-07/364.html" title="学习Html5建站教程（二）Html5 语法与规则">学习Html5建站教程（二）Html5 语法与规则</a></li><li><a href="/jstt/css3/2013-07-07/365.html" title="学习Html5建站教程（三）Html5博客页面设计之理论">学习Html5建站教程（三）Html5博客页面设计之理论</a></li><li><a href="/jstt/css3/2013-07-08/368.html" title="学习Html5建站教程（四）用HTML5做个人的网站">学习Html5建站教程（四）用HTML5做个人的网站</a></li><li><a href="/download/case/company/2013-06-13/262.html" title="3dst web">3dst web</a></li><li><a href="/jstt/bj/2013-06-08/178.html" title="Web Color Design——设计师谈网页配色艺术">Web Color Design——设计师谈网页配色艺术</a></li>      </ul>
    </div>
<div class="blank"></div>
<div class="ad">
<script type="text/javascript">
var cpro_id="u2064486";
(window["cproStyleApi"] = window["cproStyleApi"] || {})[cpro_id]={at:"3",rsi0:"700",rsi1:"250",pat:"6",tn:"baiduCustNativeAD",rss1:"#FFFFFF",conBW:"1",adp:"1",ptt:"0",titFF:"%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91",titFS:"",rss2:"#000000",titSU:"0",ptbg:"90",piw:"0",pih:"0",ptp:"0"}
</script>
<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script></div>

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
          <li><a href="/">站长推荐</a></li>
        </ul>
      </div>
      <div class="ms-main" id="ms-main">
        <div style="display: block;" class="bd bd-news" >
          <ul>
            <li><a href="/" target="_blank">住在手机里的朋友</a></li>
            <li><a href="/" target="_blank">教你怎样用欠费手机拨打电话</a></li>
            <li><a href="/" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
            <li><a href="/" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
            <li><a href="/" target="_blank">你面对的是生活而不是手机</a></li>
            <li><a href="/" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li>
          </ul>
        </div>
        <div  class="bd bd-news">
          <ul>
            <li><a href="/" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
            <li><a href="/" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
            <li><a href="/" target="_blank">住在手机里的朋友</a></li>
            <li><a href="/" target="_blank">教你怎样用欠费手机拨打电话</a></li>
            <li><a href="/" target="_blank">你面对的是生活而不是手机</a></li>
            <li><a href="/" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li>
          </ul>
        </div>
        <div class="bd bd-news">
          <ul>
            <li><a href="/" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
            <li><a href="/" target="_blank">你面对的是生活而不是手机</a></li>
            <li><a href="/" target="_blank">住在手机里的朋友</a></li>
            <li><a href="/" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li>
            <li><a href="/" target="_blank">教你怎样用欠费手机拨打电话</a></li>
            <li><a href="/" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
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
      <h3>图文推荐</h3>
      <ul>
        <li><a href="/"><img src="${pageContext.request.contextPath}/blogResources/images/01.jpg"><b>住在手机里的朋友</b></a>
          <p><span class="tulanmu"><a href="/">手机配件</a></span><span class="tutime">2015-02-15</span></p>
        </li>
        <li><a href="/"><img src="${pageContext.request.contextPath}/blogResources/images/02.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
          <p><span class="tulanmu"><a href="/">手机配件</a></span><span class="tutime">2015-02-15</span></p>
        </li>
        <li><a href="/" title="手机的16个惊人小秘密，据说99.999%的人都不知"><img src="${pageContext.request.contextPath}/blogResources/images/03.jpg"><b>手机的16个惊人小秘密，据说...</b></a>
          <p><span class="tulanmu"><a href="/">手机配件</a></span><span class="tutime">2015-02-15</span></p>
        </li>
        <li><a href="/"><img src="${pageContext.request.contextPath}/blogResources/images/06.jpg"><b>住在手机里的朋友</b></a>
          <p><span class="tulanmu"><a href="/">手机配件</a></span><span class="tutime">2015-02-15</span></p>
        </li>
        <li><a href="/"><img src="${pageContext.request.contextPath}/blogResources/images/04.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
          <p><span class="tulanmu"><a href="/">手机配件</a></span><span class="tutime">2015-02-15</span></p>
        </li>
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
  <p class="ft-copyright">兔小白博客 Design by DanceSmile 蜀ICP备11002373号-1</p>
  <div id="tbox"> <a id="togbook" href="/"></a> <a id="gotop" href="javascript:void(0)"></a> </div>
</footer>
</body>
</html>
