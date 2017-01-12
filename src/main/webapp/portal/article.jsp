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
      <p>遇到很多新手，都会问，如果要学习web前端开发，需要学习什么？难不难？多久能入门？怎么能快速建一个网站？工资能拿到多少？还有些让我推荐一些培训机构什么的要去学习。我建议是自学，实在是觉得自己没有这个能力，确实是需要一个老师的话，那你还是自己做主找个老师吧！为什么要自学呢，现在的老师水平都可以说是参差不平，运气好，你遇到个好老师，把毕生的经验和技巧都教给了你，运气不好，遇到个照本宣科的老师，那你的知识也会仅仅局限于教材！也许还有更糟糕的是，学到的书本知识两年前就已经开始有了大的变化，你并不知道关于更多的web设计这方面的知识。如果在这样的情况下，都还不如那些闭关自学的学生。</p>
<p>学习最好的老师就是兴趣，没有兴趣而言，这条路我相信你是走不长远的，除非你有其他比如说生活压力，工作压力等让你不得不这样坚持下去。我刚开始接触web网页设计的时候，教材都是以table来布局的，看到插入table生成了很多标签代码后，tr里面一个个td，理不清楚这个里面怎么回事。敷衍的学习了一个学期。还是没学到什么。真正学到的还是停留在怎么新建，怎么保存。</p>
<p>如果你还是在校学生，那你得好好上课，大学的教材普遍来讲都是知识面浅的。虽然很多知识看起来用处不大，学起来也很枯燥，让你觉得浪费时间。但这些书本上最基础的知识你都不能掌握，那你以后怎么追求更精湛的技术呢。所以不要逃课，把基础知识掌握了，别小看这个基础知识，它非常重要，基础扎实是否也会决定你在一个职业能走多远。</p>
<p>我是毕业了后从文员转到编辑再到技术员当然这期间工资就像是阶梯一样，虽然这差距也不是很大，都离不开那些曾经被我遗落角落的专业课本。生活上的压力迫使我这样做，我知道自己要什么，当一个文员没有追求，感觉过着30、40岁人的生活，接电话、发email、整理报表，每个月都有白领的工资...浪费的不仅仅是自己的青春，还有这大学几年昂贵的学费。后来就愈来愈想掌握一门技术，想去培训学校学习一段时间，但是现实是我没有钱，闭关一个星期，重拾课本，再看看那些讨厌的table，虽然out了，但是确实会发现很多基础再基础不过的东西，利用互联网，不明白的就百度，作为一个过来人，我觉得我自己走了不少弯路，所以，有必要提醒你们一下，一定要明确自己的目标，摆正自己的位置，最好掌握一门技术。</p>

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
<p>上一篇：<a href="/jstt/bj/2013-07-24/523.html">CSS简明教程（三）——css样式高级技巧</a></p>
<p>下一篇：<a href="/jstt/bj/2013-07-31/532.html">Fieldset教你如何绘制带标题的表单框</a></p>
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
