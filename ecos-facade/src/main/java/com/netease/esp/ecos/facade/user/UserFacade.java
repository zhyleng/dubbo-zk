package com.netease.esp.ecos.facade.user;

import com.netease.esp.ecos.user.model.User;

/**
 * 用户Facade
 */
public interface UserFacade {
	
	User getUser(long id);
}
