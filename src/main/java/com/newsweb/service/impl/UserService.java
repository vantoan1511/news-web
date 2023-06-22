package com.newsweb.service.impl;

import javax.inject.Inject;

import com.newsweb.dao.IUserDAO;
import com.newsweb.model.UserModel;
import com.newsweb.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) {
		return userDAO.findByUsernameAndPasswordAndStatus(username, password, status);
	}

}
