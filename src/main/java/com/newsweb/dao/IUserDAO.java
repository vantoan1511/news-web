package com.newsweb.dao;

import com.newsweb.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{

	UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status);
}
