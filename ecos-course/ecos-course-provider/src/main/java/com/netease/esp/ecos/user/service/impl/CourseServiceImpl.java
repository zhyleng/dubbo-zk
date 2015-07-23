package com.netease.esp.ecos.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.esp.ecos.course.dao.CourseDAO;
import com.netease.esp.ecos.course.model.Course;
import com.netease.esp.ecos.course.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDAO;
	
	@Override
	public Course getCourse(long id) {
		// TODO Auto-generated method stub
		return courseDAO.query(id);
	}

}
