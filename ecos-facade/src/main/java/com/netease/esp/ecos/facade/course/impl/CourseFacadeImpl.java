package com.netease.esp.ecos.facade.course.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.netease.esp.ecos.course.model.Course;
import com.netease.esp.ecos.course.service.CourseService;
import com.netease.esp.ecos.facade.course.CourseFacade;

/**
 * 用户Facade
 *
 */
@Service("courseFacade")
public class CourseFacadeImpl implements CourseFacade{
	@Resource
    CourseService courseService;

	@Override
	public Course getCourse(long id) {
		// TODO Auto-generated method stub
		return courseService.getCourse(id);
	}
	
}
