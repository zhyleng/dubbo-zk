package com.netease.esp.ecos.mainsite.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.esp.ecos.course.model.Course;
import com.netease.esp.ecos.facade.course.CourseFacade;
import com.netease.esp.ecos.facade.user.UserFacade;
import com.netease.esp.ecos.user.model.User;

@Controller
public class Testcontroller {
	Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	UserFacade userFacade;
	@Autowired
	CourseFacade courseFacade;
	 
	@RequestMapping(value = "/user")
	public String TestController(Model model) {
		try {
			User user = userFacade.getUser(1);
			System.out.println(user.toString());
			model.addAttribute("user", user);
			logger.warn("成功!");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("发生错误！");
		}
		return "index";
	}
	
	@RequestMapping(value = "/course")
	public String getCourse(Model model) {
		try {
			Course course = courseFacade.getCourse(12123);
			System.out.println(course.toString());
			model.addAttribute("course", course);
			logger.warn("成功!");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("发生错误！");
		}
		return "course";
	}
	
}
