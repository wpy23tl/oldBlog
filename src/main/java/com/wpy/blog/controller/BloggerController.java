package com.wpy.blog.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wpy.blog.entity.Blogger;
import com.wpy.blog.service.BloggerService;
import com.wpy.blog.util.CryptographyUtil;


/**
 * 博主Controller层
 * @author java1234_小锋
 *
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@Resource
	private BloggerService bloggerService;
	
	/**
	 * 用户登录
	 * @param blogger
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Blogger blogger,HttpServletRequest request){
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(blogger.getUserName(), CryptographyUtil.md5(blogger.getPassword(), "java1234"));
		try{
			subject.login(token); // 登录验证
			return "redirect:/admin/main.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("blogger", blogger);
			request.setAttribute("errorInfo", "用户名或密码错误！");
			return "login/login";
		}
	}

	/**
	 * 跳转到关于我页面
	 * @param blogger
	 * @param request
	 * @return
	 */
	@RequestMapping("/goAboutMe")
	public String goAboutMe(Blogger blogger, HttpServletRequest request, Model model, String id){
		Blogger blogger1 = bloggerService.getBlogById(Integer.valueOf(id));
		model.addAttribute("aboutMe",blogger1.getAboutMe());
		return "forceGround/aboutMe";
	}
	
}
