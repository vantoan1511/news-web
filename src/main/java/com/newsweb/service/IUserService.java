package com.newsweb.service;

import com.newsweb.model.UserModel;

public interface IUserService {

	UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status);
}
