package com.netease.esp.ecos.user.dao;

import org.springframework.dao.DataAccessException;

import com.netease.esp.ecos.user.model.User;


public interface UserDAO {
	int insert(User user) throws DataAccessException;
	User query(long id) throws DataAccessException;
}
