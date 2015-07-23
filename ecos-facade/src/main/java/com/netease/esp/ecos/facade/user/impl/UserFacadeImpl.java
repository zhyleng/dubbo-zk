package com.netease.esp.ecos.facade.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.netease.esp.ecos.facade.user.UserFacade;
import com.netease.esp.ecos.user.model.User;
import com.netease.esp.ecos.user.service.UserService;

/**
 * 用户Facade
 *
 */
@Service("userFacade")
public class UserFacadeImpl implements UserFacade{
	@Resource
    UserService userService;

	@Override
	public User getUser(long id) {
		return userService.getUser(id);
	}
	
}
