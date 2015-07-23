package com.netease.esp.ecos.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.esp.ecos.user.dao.UserDAO;
import com.netease.esp.ecos.user.model.User;
import com.netease.esp.ecos.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public User getUser(long id) {
		// TODO Auto-generated method stub
		return userDAO.query(id);
	}

}
