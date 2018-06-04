package com.cactus.cquwl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ContentPageController {

	//首页
	@RequestMapping(value={"/","/index"})
	public String dashboard(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/index";
	}
	
	@RequestMapping(value="/toLogin")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model){
		return "login";
	}
	//个人中心
	@RequestMapping(value="/grcenter")
	public String grcenter(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/grcenter";
	}
	
	//货源
	@RequestMapping(value="/soucegoods")
	public String soucegoods(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/soucegoods";
	}
	
	//车源
	@RequestMapping(value="/soucecar")
	public String soucecar(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/soucecar";
	}
	
	//仓库源
	@RequestMapping(value="/soucedb")
	public String soucedb(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/soucedb";
	}
	
	//招商加盟
	@RequestMapping(value="/zsjm")
	public String zsjm(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/zsjm";
	}
	
	@RequestMapping(value="/successAssess")
	public String successAssess(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/successAssess";
	}
	
}
