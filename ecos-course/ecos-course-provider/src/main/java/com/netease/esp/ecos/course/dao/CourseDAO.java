package com.netease.esp.ecos.course.dao;

import org.springframework.dao.DataAccessException;

import com.netease.esp.ecos.course.model.Course;


public interface CourseDAO {
	int insert(Course course) throws DataAccessException;
	Course query(long id) throws DataAccessException;
}
